package com.enroutesystems;


import com.enroutesystems.yugioh.Duelista;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Slf4j
public class CollectionTest {

    @Test
    public void sortTest() {
        List<Duelista> duelista = new ArrayList<>();
        Duelista kaiba = new Duelista("Kaiba", 8000, null);
        Duelista joey = new Duelista("Joey", 8000, null);
        Duelista yugi = new Duelista("Yugi", 8000, null);
        duelista.add(kaiba);
        duelista.add(joey);
        duelista.add(yugi);
        Collections.sort(duelista);
        duelista.forEach(d->log.info(d.getNombre()));
        Collections.reverse(duelista);
        duelista.forEach(d->log.info(d.getNombre()));
       // log.info("duelitas {}",duelista);
    }


    @Test
    public void bynarySearchTest() {
        List<Duelista> duelista = new ArrayList<>();
        Duelista kaiba = new Duelista("Kaiba", 1000, null);
        Duelista joey = new Duelista("Joey", 100, null);
        Duelista yugi = new Duelista("Yugi", 8000, null);
        duelista.add(kaiba);
        duelista.add(joey);
        duelista.add(yugi);
        Collections.sort(duelista);
        duelista.forEach(d->log.info(d.getNombre()));
        int binarySearh = Collections.binarySearch(duelista,kaiba);
        log.info("duelitas {} at intex {}",duelista.get(binarySearh),binarySearh);
    }


    @Test
    public void unmodifiableCollection() {
        List<Duelista> duelista = new ArrayList<>();
        Duelista kaiba = new Duelista("Kaiba", 1000, null);
        Duelista joey = new Duelista("Joey", 100, null);
        Duelista yugi = new Duelista("Yugi", 8000, null);
        duelista.add(kaiba);
        duelista.add(joey);
        duelista.add(yugi);
        Collections.sort(duelista);
        duelista.forEach(d->log.info(d.getNombre()));
        Collection<Duelista> duelistaUn = Collections.unmodifiableCollection(duelista);
        try{
            duelistaUn.add(kaiba);
        }catch(Exception e){
            log.info("Error..",e);
        }
    }


    @Test
    public void synchronizedCollectionTest() {
        List<Duelista> duelista = new ArrayList<>();
        Duelista kaiba = new Duelista("Kaiba", 1000, null);
        Duelista joey = new Duelista("Joey", 100, null);
        Duelista yugi = new Duelista("Yugi", 8000, null);
        duelista.add(kaiba);
        duelista.add(joey);
        duelista.add(yugi);
        Collection<Duelista> duelistaUn = Collections.synchronizedCollection(duelista);
        duelistaUn.forEach(d->log.info(d.getNombre()));
    }

    @Test
    public void checkedCollectionTest() {
        List duelista =  new ArrayList<>();
        Duelista kaiba = new Duelista("Kaiba", 1000, null);
        Duelista joey =  new Duelista("Joey", 100, null);
        Duelista yugi =  new Duelista("Yugi", 8000, null);
        duelista.add(kaiba);
        duelista.add(joey);
        duelista.add(yugi);
        Collection duelistaUn = Collections.checkedCollection(duelista,Duelista.class);
        try{
            duelistaUn.add("Test");
        }catch(Exception e){
            log.info("Error..",e);
        }
    }

    @Test
    public void copyCollectionTest() {
        List<Duelista> heroes = new ArrayList<>();
        Duelista kaiba = new Duelista("Kaiba", 1000, null);
        Duelista joey = new Duelista("Joey", 100, null);
        Duelista yugi = new Duelista("Yugi", 8000, null);
        heroes.add(kaiba);
        heroes.add(joey);
        heroes.add(yugi);
        List<Duelista> villanos = new ArrayList<>();
        Duelista pegasus = new Duelista("Pegasus", 1000, null);
        villanos.add(pegasus);
        Collections.copy(heroes,villanos);
        heroes.forEach(duelista->{log.info(duelista.getNombre());});
    }

    @Test
    public void nCopyTest() {
        Duelista kaiba = new Duelista("Kaiba", 1000, null);
        List<Duelista> duelistas = Collections.nCopies(5,kaiba);
        duelistas.forEach(duelista->{log.info(duelista.getNombre());});
    }

    @Test
    public void emptyList() {
        Duelista kaiba = new Duelista("Kaiba", 1000, null);
        List<Duelista> duelistas = Collections.emptyList();
        try{
            duelistas.add(kaiba);
        }catch(Exception e){
            log.info("Error..",e);
        }
    }


    @Test
    public void reduceTest() {
        List<String> example = new ArrayList<>();
        example.add("example1");
        example.add("example2");
        example.add("example3");
        Optional<String> reduced = example.stream().reduce((s1,s2)->s1+","+s2);
        log.info(reduced.get());
    }

    @Test
    public void reduceIntTest() {
        int result = IntStream.range(0,10).reduce(0,(a,b)->a+b);
        log.info(result+"");
    }


    @Test
    public void reduceObjTest() {
        List<Duelista> heroes = new ArrayList<>();
        Duelista kaiba = new Duelista("Kaiba", 1000, null);
        Duelista joey = new Duelista("Joey", 100, null);
        Duelista yugi = new Duelista("Yugi", 8000, null);
        heroes.add(kaiba);
        heroes.add(joey);
        heroes.add(yugi);
        BinaryOperator biFunction = (BinaryOperator<Integer>) (sum, sum2) -> sum+sum2;
        Integer lifePoints = heroes.stream().reduce(0,(sum,d) -> sum += new Double(d.getLifePoints()).intValue(),biFunction);
        log.info("sum life poinits {}",lifePoints);
    }

    @Test
    public void linkedObjTest() {
        List<Duelista> heroes = new LinkedList<>();
        Duelista kaiba = new Duelista("Kaiba", 1000, null);
        Duelista joey = new Duelista("Joey", 100, null);
        Duelista yugi = new Duelista("Yugi", 8000, null);
        Duelista marin = new Duelista("marin", 8000, null);
        heroes.add(kaiba);
        heroes.add(joey);
        heroes.add(yugi);
        heroes.set(0,marin);
        heroes.stream().peek(duelista->log.info("{}",duelista)).collect(Collectors.toList());
        ShortToByte shortToByte = s -> (byte)(s*2);
        byte b = shortToByte.applyAsByte((short)2);
    }

    @FunctionalInterface
    interface ShortToByte{
        byte applyAsByte(short s);
    }
}


