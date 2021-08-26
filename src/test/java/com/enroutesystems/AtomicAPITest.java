package com.enroutesystems;


import com.enroutesystems.yugioh.Carta;
import com.enroutesystems.yugioh.CartaMonstruo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class AtomicAPITest {


    @Test
    public void customAnnotationMagia() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Carta magoOscuro = new CartaMonstruo("Mago Oscuro", 0, 2000);
        Runnable task1 = () -> {
            for (int i = 0; i < 2000; i++) {
                magoOscuro.incrementarAtaque();
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < 2000; i++) {
                magoOscuro.incrementarAtaque();
            }
        };
        executorService.submit(task1);
        executorService.submit(task2);
        try {
            executorService.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Atk final:" + magoOscuro.getAtaque());
    }

    @Test
    public void customAnnotationMagiaAtomic() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Carta magoOscuro = new CartaMonstruo("Mago Oscuro", new AtomicLong(0l), 2000);
        Runnable task1 = () -> {
            for (int i = 0; i < 2000; i++) {
                magoOscuro.incrementarAtaqueAtomic();
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < 2000; i++) {
                magoOscuro.incrementarAtaqueAtomic();
            }
        };
        executorService.submit(task1);
        executorService.submit(task2);
        try {
            executorService.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Atk final:" + magoOscuro.getAtaqueAtomic().get());
    }


    @Test
    public void customAnnotationMagiaBooleanAtomic() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Carta magoOscuro = new CartaMonstruo("Mago Oscuro", new AtomicLong(0l), 2000, true);
        Runnable task2 = () -> {
            while (magoOscuro.isEdicionPrimera()) {
                log.info("Mago oscuro is atk");
            }
        };
        Runnable task1 = () -> {
            magoOscuro.setEdicionPrimera(false);
        };
        executorService.submit(task2);
        executorService.submit(task1);
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Atk final:" + magoOscuro.getAtaqueAtomic().get());
    }
}
