package com.company;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {43,154,63,945,732};
        bubble_sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void bubble_sort(int[] a){
        boolean swap;
        for (int i = 0; i < a.length; i++) {
            swap = false;
            for (int j = 1; j < a.length - i; j++) {
                if(a[j-1] > a[j]){
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                    swap = true;
                }
            }
            if(!swap){
                break;
            }
        }
    }
}
