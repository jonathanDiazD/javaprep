package com.enroutesystems;


import com.enroutesystems.yugioh.Carta;
import com.enroutesystems.yugioh.CartaMagia;
import com.enroutesystems.yugioh.CartaMonstruo;
import com.enroutesystems.yugioh.Duelista;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Collections;
import java.util.LinkedList;

@SpringBootTest
@Slf4j
public class Duelo {



    @Test
    public void inicializarDuelista1() {

        try {

            LinkedList<Carta> deck = new LinkedList<>();
            Carta magoOscuro = new CartaMonstruo("Mago Oscuro",2500,2000);
            Carta monstruoRenacido = new CartaMagia("Monstruo renacido",0l,0l,"Revives un monstruo del cementerio");
            Carta magaOscura = new CartaMonstruo("Mago Oscura",2500,2000);
            deck.add(magoOscuro);
            deck.add(monstruoRenacido);
            deck.add(magaOscura);
            Collections.shuffle(deck);
            Duelista yugi = new Duelista("Yugi",8000,deck);
            yugi.sacarCarta();
            yugi.sacarCarta();
            log.info("Mano actual yu gi:"+yugi.getMano());

        } catch (Exception e) {
            log.error("Got exception: {}", e.getMessage(), e);
        } finally {
            log.info("Continuara....");
        }
    }



    @Test
    public void inicializarDuelista2() {

        try {
            LinkedList<Carta> deck = new LinkedList<>();
            Carta dragonOjosAzules = new CartaMonstruo("Dragon Ojos azules",3000,2500);
            Carta brazoExodia = new CartaMonstruo("Brazo izquierdo Exodia",0,0);
            deck.add(dragonOjosAzules);
            deck.add(brazoExodia);
            Collections.shuffle(deck);
            Duelista kaiba = new Duelista("Kaiba",8000,deck);
            kaiba.sacarCarta();
            log.info("Mano actual Kaiba:"+kaiba.getMano());
            log.info("Poder ataque kaiba:"+kaiba.sumarizarPoderAtk());
        } catch (Exception e) {
            log.error("Got exception: {}", e.getMessage(), e);
        } finally {
            log.info("Continuara....");
        }
    }

}
