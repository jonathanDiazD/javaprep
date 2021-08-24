package com.enroutesystems;


import com.enroutesystems.yugioh.Carta;
import com.enroutesystems.yugioh.CartaMonstruo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

@Slf4j
public class MapTest {

    @Test
    public void hashMapTest(){
        Map<String, Carta> mapCarta = new HashMap<>();
        Carta magoOscuro = new CartaMonstruo("Mago Oscuro", 2500, 2000);
        mapCarta.put("magician",magoOscuro);
        log.info("Mago oscuro {}",mapCarta.get("magician"));
    }

    @Test
    public void treeMapTest(){
        Map<String, Carta> mapCarta = new TreeMap<>();
        Carta magoOscuro = new CartaMonstruo("Mago Oscuro2", 2500, 2000);
        mapCarta.put("magoOscuro",magoOscuro);
        mapCarta.put("astharot",magoOscuro);
        mapCarta.put("astral",magoOscuro);
        mapCarta.put("magaOscura",magoOscuro);
        mapCarta.put("dragon",magoOscuro);
        mapCarta.keySet().stream().peek(k->log.info(k)).count();
    }



    @Test
    public void hashTableTest(){
        Map hashtable = new Hashtable();
        Carta magoOscuro = new CartaMonstruo("Mago Oscuro2", 2500, 2000);
        hashtable.put("astral",magoOscuro);
        hashtable.put("magaOscura",magoOscuro);
        hashtable.put("dragon",magoOscuro);
        hashtable.put("magoOscuro",magoOscuro);
        hashtable.put("astharot",magoOscuro);
        hashtable.keySet().stream().peek(k->log.info("working {}",k)).count();



    }
}
