package com.enroutesystems;


import com.enroutesystems.yugioh.Duelista;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


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




}
