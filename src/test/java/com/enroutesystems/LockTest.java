package com.enroutesystems;


import com.enroutesystems.yugioh.Carta;
import com.enroutesystems.yugioh.CartaMonstruo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class LockTest {

    @Test
    public void lockTest() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Carta magoOscuro = new CartaMonstruo("Mago Oscuro", 0, 2000);
        Runnable task1 = () -> {
            for (int i = 0; i < 2000; i++) {
                magoOscuro.incrementarAtaqueLock();
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < 2000; i++) {
                magoOscuro.incrementarAtaqueLock();
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
}
