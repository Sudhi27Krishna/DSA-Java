package com.company;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = {43,154,63,945,732};
//        mergesort(a,0,a.length-1);
        mergeSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    static void merge(int[] arr, int s, int e){
        int m = s + (e - s) / 2;
        int n1 = m - s + 1;
        int n2 = e - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[s + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[m + 1 + i];
        }

        int i, j, k;
        i = 0;
        j = 0;
        k = s;

        while(i < n1 && j < n2){
            if(left[i] < right[j]){
                arr[k] = left[i];
                i++;
            }else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < n1){
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < n2){
            arr[k] = right[j];
            j++;
            k++;
        }
    }
    static void mergeSort(int[] arr, int s, int e){
        if(s < e){
            int m = s + (e - s) / 2;
            mergeSort(arr,s,m);
            mergeSort(arr,m+1,e);
            merge(arr,s,e);
        }
    }
}
