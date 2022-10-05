package com.company;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {-35,61,32,95,68,48};
        selection(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void selection(int[] a){
        for (int i = 0; i < a.length; i++) {
            int last = a.length - i - 1;
            int maxIndex = getMaxIndex(a, last);
            swap(a,maxIndex,last);
        }
    }
    static void swap(int[] a,int first,int second){
        int temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }
    private static int getMaxIndex(int[] a, int end) {
        int max = 0;
        for (int i = 0; i <= end; i++) {
             if(a[max] < a[i]){
                 max = i;
             }
        }
        return max;
    }
}
