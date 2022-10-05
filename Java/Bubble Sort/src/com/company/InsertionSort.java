package com.company;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
       int[] arr = {5,3,2,4,1};
       insertion_sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void insertion_sort(int[] a){
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j > 0 ; j--) {
                     if(a[j] < a[j - 1]){
                         swap(a, j,j - 1);
                     }else{
                         break;
                     }
            }
        }
    }
    static void swap(int[] a,int first,int second){
        int temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }
}
