package com.enroutesystems;


import com.enroutesystems.yugioh.Duelista;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Slf4j
public class StreamTest {

    @Test
    public void supplier() {
        List<Duelista> heroes = new LinkedList<>();
        Duelista kaiba = new Duelista("Kaiba", 1000, null);
        Duelista joey = new Duelista("Joey", 100, null);
        Duelista yugi = new Duelista("Yugi", 8000, null);
        Duelista marin = new Duelista("marin", 8000, null);
        heroes.add(kaiba);
        heroes.add(joey);
        heroes.add(yugi);
        heroes.add(yugi);
        heroes.set(0,marin);
        Stream<Duelista> stream = heroes.stream();
        stream.collect(Collectors.toSet()).forEach(d->log.info(d.getNombre()));
    }

    @Test
    public void streamMap() {
        List<Duelista> heroes = new LinkedList<>();
        Duelista kaiba = new Duelista("Kaiba", 1000, null);
        Duelista joey = new Duelista("Joey", 100, null);
        Duelista yugi = new Duelista("Yugi", 8000, null);
        Duelista marin = new Duelista("marin", 8000, null);
        heroes.add(kaiba);
        heroes.add(joey);
        heroes.add(yugi);
        heroes.add(yugi);
        heroes.set(0,marin);
        Set<String> lstHeroes = heroes.stream().map(d -> d.getNombre()).collect(Collectors.toSet());
        log.info("Heroes {}",lstHeroes);
    }

    @Test
    public void streamAllmatch() {
        List<Duelista> heroes = new LinkedList<>();
        Duelista kaiba = new Duelista("Kaiba", 1000, null);
        Duelista joey = new Duelista("Joey", 100, null);
        heroes.add(kaiba);
        heroes.add(joey);
        boolean match = heroes.stream().allMatch(h->h.getLifePoints()>5000);
        log.info("Heroes {}",match);
    }


    @Test
    public void streamNoneMatch() {
        List<Duelista> heroes = new LinkedList<>();
        Duelista kaiba = new Duelista("Kaiba", 1000, null);
        Duelista joey = new Duelista("Joey", 100, null);
        heroes.add(kaiba);
        heroes.add(joey);
        boolean match = heroes.stream().noneMatch(h->h.getLifePoints()>5000);
        log.info("Heroes {}",match);
    }


    @Test
    public void optional() {
        String value = (String) Optional.ofNullable(null).orElseGet(new Supplier<Object>() {
            @Override
            public Object get() {
                return "Hello Worlds.";
            }
        });
        log.info(value+"");
    }

    @Test
    public void optionalConsumer() {
        Optional.ofNullable("it actualli works").ifPresent(o -> log.info("o"));
    }


}
