package com.enroutesystems;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.IntConsumer;

@Slf4j
public class MergeSortTest {


    //0,2,5
    void merge(int arr[], int left, int middle, int right) {
        //3
        int low = middle - left + 1;                    //size of the left subarray
        //3
        int high = right - middle;                      //size of the right subarray

        int L[] = new int[low];                             //create the left and right subarray
        int R[] = new int[high];

        int i = 0, j = 0;

        for (i = 0; i < low; i++)                               //copy elements into left subarray
        {
            L[i] = arr[left + i];
        }
        for (j = 0; j < high; j++)                              //copy elements into right subarray
        {
            R[j] = arr[middle + 1 + j];
        }


        int k = left;                                           //get starting index for sort
        i = 0;                                             //reset loop variables before performing merge
        j = 0;

        while (i < low && j < high)                     //merge the left and right subarrays
        {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < low)                             //merge the remaining elements from the left subarr
        {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < high)                           //merge the remaining elements from right subarray
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


    //0 - 2
    //0 - 2
    //3 - 5
    //0 - 1
    //
    void mergeSort(int arr[], int left, int right)       //helper function that creates the sub cases for sorting
    {
        int middle;
        if (left < right) {                             //sort only if the left index is lesser than the right index (meaning that sorting is done)
            middle = (left + right) / 2;
            mergeSort(arr, left, middle);                    //left subarray
            mergeSort(arr, middle + 1, right);               //right subarray
            merge(arr, left, middle, right);//0,2,5                //merge the two subarrays
        }
    }

    void display(int arr[])                 //display the array
    {
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
    }

    @Test
    public void mergeSortTest() {
        int arr[] = {9, 3, 1, 5, 13, 12};
        mergeSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            log.info(i + "");
        }
        display(arr);
    }

}
