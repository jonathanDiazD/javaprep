package com.enroutesystems;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@Slf4j
public class SelectionSortTest {


    @Test
    public void selectionSort(){
        int arr[] = {64,25,12,22,11};
        selectionSort(arr);
        Arrays.stream(arr).forEach(e->log.info("Numero {}",e));
    }

    private void selectionSort(int arr[]){
        int pos;
        int temp;
        for(int i=0;i<arr.length;i++){
            pos=i;
            for(int j=i+1;j<arr.length;j++){
                if (arr[j]<arr[pos]) {
                    pos = j;
                }
            }
            temp = arr[pos];
            arr[pos]=arr[i];
            arr[i]=temp;
        }
    }


}
