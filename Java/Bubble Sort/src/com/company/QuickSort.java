package com.company;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] num = {94,32,16,12,42,2,65,86,55};
        quickSort(num,0, num.length-1);
        System.out.println(Arrays.toString(num));
    }
    public static void quickSort(int[] arr,int low,int high){
        if(low >= high){
            return;
        }
        int s = low;
        int e = high;
        int mid = s + (e-s) / 2;
        int pivot = arr[mid];

        while(s <= e){
            while(arr[s] < pivot){
                s++;
            }
            while(arr[e] > pivot){
                e--;
            }
            if(s <= e){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
        // pivot at correct index,now time for the recursion calls to sort the two halves
        quickSort(arr,low,e);
        quickSort(arr,s,high);
    }
}
