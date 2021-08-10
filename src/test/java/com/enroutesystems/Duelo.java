package com.enroutesystems;


import com.enroutesystems.yugioh.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Collections;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class Duelo {


    /*Palabras reservadas que no se utilizan:
        goto
        const
    * */



    /*Palabras reservadas que se contemplan en el TEST
       *
           abstract			new
           default		package
           boolean  private	this
           break	double	implements	protected
           byte	 import	public
           case	enum instanceof	return
           catch extends int	short	try
           char	 interface		void
           class finally	long
           float		super
       *
       * */
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


    /*Palabras reservadas que se contemplan en el TEST
       *
           abstract	continue	for	new	switch
         	default		package
           boolean	do	if	private	this
           break	double	implements	protected	throw
           byte	else	import	public	throws
           case	enum	instanceof	return
           catch	extends	int	short	try
           char		interface		void
           class	finally	long
           float		super	while
       *
       * */
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
            Carta carta = kaiba.sacarCarta();
            if(carta==null){
                throw new Exception();
            }
            log.info("Mano actual Kaiba:"+kaiba.getMano());
            log.info("Poder ataque kaiba:"+kaiba.sumarizarPoderAtk());
        } catch (Exception e) {
            log.error("Got exception: {}", e.getMessage(), e);
        } finally {
            log.info("Continuara....");
        }
    }


    private Duelista getDuelistaKaiba(){
        LinkedList<Carta> deck = new LinkedList<>();
        Carta dragonOjosAzules = new CartaMonstruo("Dragon Ojos azules",3000,2500);
        Carta brazoExodia = new CartaMonstruo("Brazo izquierdo Exodia",0,0);
        deck.add(dragonOjosAzules);
        deck.add(brazoExodia);
        Collections.shuffle(deck);
        Duelista kaiba = new Duelista("Kaiba",8000,deck);
        kaiba.sacarCarta();
        return kaiba;
    }

    private Duelista getDuelistaYuGi(){
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
        return yugi;
    }


    /*Palabras reservadas que se contemplan en el TEST
   *
     		synchronized
         	transient
            volatile
            final
            static
   *
   * */
    @Test
    public void enviarCementerio() {

        try {

            TableroJuego tableroJuego = new TableroJuego();
            Duelista yugi = getDuelistaYuGi();
            Duelista kaiba = getDuelistaKaiba();
          Thread enviarCementerioYuGi = new Thread(new Runnable() {
              @Override
              public void run() {
                tableroJuego.enviarCementerio(yugi.getMano().remove(0));
                tableroJuego.setTiempoDuelo(12.3f);
              }
          });
          Thread enviarCementerioKaiba = new Thread(new Runnable() {
                @Override
                public void run() {
                    tableroJuego.enviarCementerio(kaiba.getMano().remove(0));
                }
          });
          enviarCementerioKaiba.start();
          enviarCementerioYuGi.start();
          enviarCementerioKaiba.join();
          enviarCementerioYuGi.join();
          log.info("Cementerio:"+tableroJuego.getCementerio());
          assertThat(tableroJuego.getCementerio().size()==2);
        } catch (Exception e) {
            log.error("Got exception: {}", e.getMessage(), e);
        } finally {
            log.info("Continuara....");
        }
    }

}
