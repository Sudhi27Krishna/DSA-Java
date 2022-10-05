package com.company;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {3,5,2,1,4};
        cyc_sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void swap(int[] a,int first,int second){
        int temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }
    static void cyc_sort(int[] a){
        int i = 0;
        while(i < a.length){
             int correct = a[i] - 1;
             if(a[correct] != a[i] ){
                 swap(a,correct,i);
             }else{
                 i++;
             }
        }
    }
}
