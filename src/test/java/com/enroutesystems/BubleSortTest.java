package com.enroutesystems;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@Slf4j
public class BubleSortTest {

    @Test
    public void bubleSort() {
        int arr[] = {64, 25, 12, 22, 11};
        bubleSort(arr, arr.length);
        Arrays.stream(arr).forEach(e -> log.info("Numero {}", e));
    }

    private void bubleSort(int arr[], int n) {
        if (n == 1) {
            return;
        }
        int temp;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        bubleSort(arr, n - 1);
    }

}
