package com.enroutesystems;


import com.enroutesystems.yugioh.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.List.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.setMaxElementsForPrinting;


@Slf4j
public class JavaKeywordsTest {




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
            Carta magoOscuro = new CartaMonstruo("Mago Oscuro", 2500, 2000);
            Carta monstruoRenacido = new CartaMagia("Monstruo renacido", 0l, 0l, "Revives un monstruo del cementerio");
            Carta magaOscura = new CartaMonstruo("Mago Oscura", 2500, 2000);
            deck.add(magoOscuro);
            deck.add(monstruoRenacido);
            deck.add(magaOscura);
            Collections.shuffle(deck);
            Duelista yugi = new Duelista("Yugi", 8000, deck);
            yugi.sacarCarta();
            yugi.sacarCarta();

            log.info("Mano actual yu gi:" + yugi.getMano());
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
            Carta dragonOjosAzules = new CartaMonstruo("Dragon Ojos azules", 3000, 2500);
            Carta brazoExodia = new CartaMonstruo("Brazo izquierdo Exodia", 0, 0);
            deck.add(dragonOjosAzules);
            deck.add(brazoExodia);
            Collections.shuffle(deck);
            Duelista kaiba = new Duelista("Kaiba", 8000, deck);
            Carta carta = kaiba.sacarCarta();
            if (carta == null) {
                throw new Exception();
            }
            log.info("Mano actual Kaiba:" + kaiba.getMano());
            log.info("Poder ataque kaiba:" + kaiba.sumarizarPoderAtk());
        } catch (Exception e) {
            log.error("Got exception: {}", e.getMessage(), e);
        } finally {
            log.info("Continuara....");
        }
    }


    private Duelista getDuelistaKaiba() {
        LinkedList<Carta> deck = new LinkedList<>();
        Carta dragonOjosAzules = new CartaMonstruo("Dragon Ojos azules", 3000, 2500);
        Carta brazoExodia = new CartaMonstruo("Brazo izquierdo Exodia", 0, 0);
        deck.add(dragonOjosAzules);
        deck.add(brazoExodia);
        Collections.shuffle(deck);
        Duelista kaiba = new Duelista("Kaiba", 8000, deck);
        kaiba.sacarCarta();
        return kaiba;
    }

    private Duelista getDuelistaYuGi() {
        LinkedList<Carta> deck = new LinkedList<>();
        Set<Carta> deckDragon = new TreeSet<>();

        Carta magoOscuro = new CartaMonstruo("Mago Oscuro", 2500, 2000);
        Carta monstruoRenacido = new CartaMagia("Monstruo renacido", 0l, 0l, "Revives un monstruo del cementerio");
        Carta magaOscura = new CartaMonstruo("Mago Oscura", 2500, 2000);
        deck.add(magoOscuro);
        deck.add(monstruoRenacido);
        deck.add(magaOscura);
        Collections.shuffle(deck);
        Duelista yugi = new Duelista("Yugi", 8000, deck);
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
            log.info("Cementerio:" + tableroJuego.getCementerio());
            assertThat(tableroJuego.getCementerio().size() == 2);
        } catch (Exception e) {
            log.error("Got exception: {}", e.getMessage(), e);
        } finally {
            log.info("Continuara....");
        }
    }


    @Test
    public void ordenarDeckTree() {
        Carta magoOscuro = new CartaMonstruo("Mago Oscuro", 2500, 2000);
        Carta monstruoRenacido = new CartaMagia("Monstruo renacido", 0l, 0l, "Revives un monstruo del cementerio");
        Carta magaOscura = new CartaMonstruo("Mago Oscura", 2000, 2000);
        TreeSet<Carta> cartas = new TreeSet<>();
        cartas.add(magoOscuro);
        cartas.add(monstruoRenacido);
        cartas.add(magaOscura);
        log.info("cartas:" + cartas);

        TreeSet<Carta> cartasOrdenadas = new TreeSet<>(Comparator.comparing(Carta::getNombre));
        cartasOrdenadas.add(magoOscuro);
        cartasOrdenadas.add(monstruoRenacido);
        cartasOrdenadas.add(magaOscura);
        log.info("cartas:" + cartasOrdenadas);
    }


    @Test
    public void deckSet() {
        Carta magoOscuro = new CartaMonstruo("Mago Oscuro", 2500, 2000);
        Carta monstruoRenacido = new CartaMagia("Monstruo renacido", 0l, 0l, "Revives un monstruo del cementerio");
        Carta magaOscura = new CartaMonstruo("Mago Oscura", 2000, 2000);
        Set<Carta> cartas = new HashSet<>();
        cartas.add(magoOscuro);
        cartas.add(magoOscuro);
        cartas.add(magoOscuro);
        cartas.add(monstruoRenacido);
        log.info("cartas:" + cartas);
    }

    //ordenamiento de acuerdo al ingreso en la colleccion
    @Test
    public void linkedDeckSet() {
        Carta magoOscuro = new CartaMonstruo("Mago Oscuro", 2500, 2000);
        Carta monstruoRenacido = new CartaMagia("Monstruo renacido", 0l, 0l, "Revives un monstruo del cementerio");
        Carta magaOscura = new CartaMonstruo("Mago Oscura", 2000, 2000);
        LinkedHashSet<Carta> cartas = new LinkedHashSet<>();
        cartas.add(magoOscuro);
        cartas.add(magoOscuro);
        cartas.add(magoOscuro);
        cartas.add(monstruoRenacido);
        log.info("cartas:" + cartas);
    }


    @Test
    public void enumSet() {

        for (ModoPelea modoPelea : ModoPelea.values()) {
            log.info("modo all:" + modoPelea.name());
        }

        for (ModoPelea modoPelea : EnumSet.of(ModoPelea.Ataque)) {
            log.info("modos ataque:" + modoPelea.name());
        }

        for (ModoPelea modoPelea : EnumSet.range(ModoPelea.Defensa, ModoPelea.BocaAbajo)) {
            log.info("modos range defensa-bocaAbajo:" + modoPelea.name());
        }
    }


    @Test
    public void vectorDeck() {
        Carta magoOscuro = new CartaMonstruo("Mago Oscuro", 2500, 2000);
        Carta monstruoRenacido = new CartaMagia("Monstruo renacido", 0l, 0l, "Revives un monstruo del cementerio");
        Carta magaOscura = new CartaMonstruo("Mago Oscura", 2000, 2000);
        Vector vector = new Vector();
        vector.add(magoOscuro);
        vector.add(monstruoRenacido);
        vector.add(magaOscura);
        log.info("vector:" + vector.capacity());
    }

    @Test
    public void linkedListDeck() {
        Carta magoOscuro = new CartaMonstruo("Mago Oscuro", 2500, 2000);
        Carta monstruoRenacido = new CartaMagia("Monstruo renacido", 0l, 0l, "Revives un monstruo del cementerio");
        Carta magaOscura = new CartaMonstruo("Mago Oscura", 2000, 2000);
        List<Carta> deck = new LinkedList();
        deck.add(magoOscuro);
        deck.add(monstruoRenacido);
        deck.add(magaOscura);
        log.info("deck capacity:" + deck);
    }

    @Test
    public void functionalInterfaces() {
        Map<String, Integer> naveMap = new HashMap<>();
        Integer value = naveMap.computeIfAbsent("John", s -> s.length());
        Function<Integer, String> intTostring = i -> i.toString();
        log.info("value:" + intTostring.apply(3));
        log.info("Value:" + value);
    }

    @Test
    public void functionalInterfacesPredicate() {
        Carta magoOscuro = new CartaMonstruo("Mago Oscuro", 2500, 2000);
        Carta monstruoRenacido = new CartaMagia("Monstruo renacido", 0l, 0l, "Revives un monstruo del cementerio");
        Carta magaOscura = new CartaMonstruo("Mago Oscura", 2000, 2000);
        List<Carta> deck = new LinkedList();
        deck.add(magoOscuro);
        deck.add(monstruoRenacido);
        deck.add(magaOscura);
        log.info("" + deck.stream().peek(c -> log.info("works->" + c.getAtaque())).count());
    }

    @Test
    public void fibonacci() {
        int[] fibs = {0, 1};
        Stream<Integer> fibonacci = Stream.generate(() -> {
            int result = fibs[1];
            int fib3 = fibs[0] + fibs[1];
            fibs[0] = fibs[1];
            fibs[1] = fib3;
            return result;
        });
        fibonacci.peek(number -> log.info(number.toString())).limit(10).count();

    }

    @Test
    public strictfp void restricFP(){
        float result = 10.0f/3.0f;
        log.info("result multiplatform indepent:"+result);
    }


    @Test
    public void inicializarDuelistaPredicate() {

        try {
            LinkedList<Carta> deck = new LinkedList<>();
            Carta magoOscuro = new CartaMonstruo("Mago Oscuro", 2500, 2000);
            Carta monstruoRenacido = new CartaMagia("Monstruo renacido", 0l, 0l, "Revives un monstruo del cementerio");
            Carta magaOscura = new CartaMonstruo("Mago Oscura", 2500, 2000);
            deck.add(magoOscuro);
            deck.add(monstruoRenacido);
            deck.add(magaOscura);
            deck.removeIf(new Predicate<Carta>() {
                @Override
                public boolean test(Carta carta) {
                    return carta.getAtaque()>0;
                }
            });
            log.info("Deck yu gi:" + deck);
        } catch (Exception e) {
            log.error("Got exception: {}", e.getMessage(), e);
        } finally {
            log.info("Continuara....");
        }
    }

    @Test
    public void inicializarDuelistaPredicateLambda() {

        try {
            LinkedList<Carta> deck = new LinkedList<>();
            Carta magoOscuro = new CartaMonstruo("Mago Oscuro", 2500, 2000);
            Carta monstruoRenacido = new CartaMagia("Monstruo renacido", 0l, 0l, "Revives un monstruo del cementerio");
            Carta magaOscura = new CartaMonstruo("Mago Oscura", 2500, 2000);
            deck.add(magoOscuro);
            deck.add(monstruoRenacido);
            deck.add(magaOscura);
            deck.removeIf(carta-> carta.getAtaque()>0);
            log.info("Deck yu gi:" + deck);

        } catch (Exception e) {
            log.error("Got exception: {}", e.getMessage(), e);
        } finally {
            log.info("Continuara....");
        }
    }


    @Test
    public void setDeck() {

        try {
            Set<Carta> deck =  new HashSet<>();
            Carta magoOscuro = new CartaMonstruo("Mago Oscuro R.", 2500, 2000);
            Carta monstruoRenacido = new CartaMagia("Monstruo renacido", 0l, 0l, "Revives un monstruo del cementerio");
            Carta dragon = new CartaMonstruo("Dragon de ojos azules", 2500, 2000);
            deck.add(magoOscuro);
            deck.add(monstruoRenacido);
            deck.add(dragon);
            deck.add(dragon);
            log.info("Deck yu gi size {}" , deck.size());
            log.info("Dragon {}", dragon);
        } catch (Exception e) {
            log.error("Got exception: {}", e.getMessage(), e);
        } finally {
            log.info("Continuara....");
        }
    }

    @Test
    public void comparableTest() {

        try {
            List<Duelista> duelistas =  new ArrayList<>();
            Duelista yugi  = new Duelista("Yugi", 8000, null);
            Duelista yugi2 = new Duelista("Yugi", 2300, null);
            Duelista yugi3 = new Duelista("Yugi", 4300, null);
            Duelista yugi4 = new Duelista("Yugi", 6700, null);
            duelistas.add(yugi);
            duelistas.add(yugi2);
            duelistas.add(yugi3);
            duelistas.add(yugi4);
            Collections.sort(duelistas);
            duelistas.forEach(duelista -> log.info("Resultados {}, and its life points are{}",duelista.getNombre(),duelista.getLifePoints()));
        } catch (Exception e) {
            log.error("Got exception: {}", e.getMessage(), e);
        } finally {
            log.info("Continuara....");
        }
    }


    @Test
    public void comparatorTest() {
        try {
            List<Duelista> duelistas =  new ArrayList<>();
            Duelista yugi  = new Duelista("YugiX", 8000, null);
            Duelista yugi2 = new Duelista("YugiE", 2300, null);
            Duelista yugi3 = new Duelista("YugiR", 4300, null);
            Duelista yugi4 = new Duelista("YugiZ", 6700, null);
            duelistas.add(yugi);
            duelistas.add(yugi2);
            duelistas.add(yugi3);
            duelistas.add(yugi4);
            Collections.sort(duelistas, Comparator.comparing(Duelista::getNombre));
            duelistas.forEach(duelista -> log.info("Resultados {}, and its life points are{}",duelista.getNombre(),duelista.getLifePoints()));
        } catch (Exception e) {
            log.error("Got exception: {}", e.getMessage(), e);
        } finally {
            log.info("Continuara....");
        }
    }

    @Test
    public void sortedSetDuelistaTest() {
        try {
            SortedSet<Duelista> duelistas =  new TreeSet<>();
            Duelista yugi  = new Duelista("YugiX", 8000, null);
            Duelista yugi2 = new Duelista("YugiE", 2300, null);
            Duelista yugi3 = new Duelista("YugiR", 4300, null);
            Duelista yugi4 = new Duelista("YugiZ", 6700, null);
            duelistas.add(yugi);
            duelistas.add(yugi2);
            duelistas.add(yugi3);
            duelistas.add(yugi4);
            duelistas.forEach(duelista -> log.info("Resultados {}, and its life points are{}",duelista.getNombre(),duelista.getLifePoints()));
        } catch (Exception e) {
            log.error("Got exception: {}", e.getMessage(), e);
        } finally {
            log.info("Continuara....");
        }
    }
}
