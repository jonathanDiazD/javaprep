package com.enroutesystems;

import com.enroutesystems.yugioh.Duelista;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Slf4j
public class ArraysTest {

    @Test
    public void asListTest() {
        Duelista kaiba = new Duelista("Kaiba", 1000, null);
        Duelista duelistas[] = {kaiba};
        Arrays.asList(duelistas).forEach(duelista -> log.info(duelista.getNombre()));
    }

    @Test
    public void sortTest() {
        Duelista kaiba = new Duelista("Kaiba", 1000, null);
        Duelista joey = new Duelista("Joey", 100, null);
        Duelista yugi = new Duelista("Yugi", 8000, null);
        Duelista duelistas[] = {kaiba,joey,yugi};
        Arrays.sort(duelistas);
        for(Duelista duelista : duelistas){
            log.info(duelista.getNombre());
        }
        StringBuilder result = new StringBuilder();


    }

    @Test
    public void bubleSortTest(){
        int arr[] = {5,3,2,9,14,8};
        for (int i : arr) {
            //log.info(i+"");
        }
        log.info("after ordering..");
        bubbleSort(arr);
        for (int i : arr) {
            log.info(i+"");
        }
    }

    private void bubbleSort(int[] arr){
        int n = arr.length;
        int temp=0;
        for(int i=0;i<n;i++){
            for(int j=1;j<(n-i);j++){
                if (arr[j-1]>arr[j]) {
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j]=temp;
                }
            }
        }
    }

    @Test
    public void arraysCopyOfTest(){
        int arr[] = {5,3,2,9,14,8};
        int[] arrCopy = Arrays.copyOf(arr,6);
        for (int i : arrCopy) {
            log.info(i+"");
        }

        long arrlong[] = {5l,3l,2l,9l,14l,8l};
        long[] arrCopylong = Arrays.copyOf(arrlong,6);
        for (long i : arrCopylong) {
            log.info(i+"");
        }
    }


    @Test
    public void arraysCopyOfrangeTest(){
        int arr[] = {5,3,2,9,14,8};
        int[] arrCopy = Arrays.copyOfRange(arr,6,10);
        for (int i : arrCopy) {
            log.info(i+"");
        }
    }

    @Test
    public void arraysDeepEqualsTest(){
        Duelista kaiba = new Duelista("Kaiba", 1000, null);
        Duelista joey = new Duelista("Joey", 100, null);
        Duelista yugi = new Duelista("Yugi", 8000, null);
        Duelista duelistas[] = {kaiba,joey,yugi};
        Duelista duelistas2[] = {kaiba,joey};
        log.info(Arrays.deepEquals(duelistas,duelistas2)+"");
    }

    @Test
    public void arraysDeepStringTest(){
        Duelista kaiba = new Duelista("Kaiba", 1000, null);
        Duelista joey = new Duelista("Joey", 100, null);
        Duelista yugi = new Duelista("Yugi", 8000, null);
        //Duelista duelistas[] = {kaiba,joey,yugi};
        List<Duelista> duelistas = new ArrayList<>();
        duelistas.add(kaiba);
        duelistas.add(joey);
        duelistas.add(yugi);
        log.info(Arrays.deepToString(duelistas.toArray()));
    }

    @Test
    public void arraysequalStringTest(){
        Duelista kaiba = new Duelista("Kaiba", 1000, null);
        Duelista joey = new Duelista("Joey", 100, null);
        Duelista yugi = new Duelista("Yugi", 8000, null);
        Duelista duelistas[] = {kaiba,joey,yugi};
        Duelista duelistas2[] = {kaiba,joey,yugi};
        log.info(Arrays.equals(duelistas,duelistas2)+"");
    }

    @Test
    public void fillTest(){
        Duelista kaiba = new Duelista("Kaiba", 1000, null);
        Duelista joey = new Duelista("Joey", 100, null);
        Duelista yugi = new Duelista("Yugi", 8000, null);
        Duelista duelistas[] = new Duelista[10];
        Arrays.fill(duelistas,joey);
        log.info(Arrays.deepToString(duelistas));
        log.info(duelistas.length+"");
    }

    @Test
    public void hascodeTest(){
        Duelista kaiba = new Duelista("Kaiba", 1000, null);
        Duelista joey = new Duelista("Joey", 100, null);
        Duelista yugi = new Duelista("Yugi", 8000, null);
        Duelista duelistas[] = {kaiba,joey};
        int hascode = Arrays.hashCode(duelistas);
        log.info("hascode:"+hascode);
    }


    @Test
    public void mergeSortTest(){
        Duelista kaiba = new Duelista("Kaiba", 1000, null);
        Duelista joey = new Duelista("Joey", 100, null);
        Duelista yugi = new Duelista("Yugi", 8000, null);
        Duelista duelistas[] = {kaiba,joey};
        Arrays.sort(duelistas);
        log.info("sort:"+Arrays.deepToString(duelistas));
    }

    @Test
    public void splitTeratorTest(){
        Duelista kaiba = new Duelista("Kaiba", 1000, null);
        Duelista joey = new Duelista("Joey", 100, null);
        Duelista yugi = new Duelista("Yugi", 8000, null);
        Duelista duelistas[] = {kaiba,joey};
        Spliterator<Duelista> spliterator = Arrays.spliterator(duelistas);
        spliterator.forEachRemaining(s->log.info(s.toString()));
    }

    @Test
    public void streamTest(){
        Duelista kaiba = new Duelista("Kaiba", 1000, null);
        Duelista joey = new Duelista("Joey", 100, null);
        Duelista yugi = new Duelista("Yugi", 8000, null);
        Duelista duelistas[] = {kaiba,joey};
        Stream<Duelista> stream = Arrays.stream(duelistas);
        stream.peek(d->log.info(d.toString())).collect(Collectors.toList());
    }
}
