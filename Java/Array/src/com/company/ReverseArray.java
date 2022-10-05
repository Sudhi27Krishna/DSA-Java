package com.company;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {54,33,54,675,545,89,97};
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void reverse(int[] a) {
      int start;
      int end = a.length-1;
      for ( start = 0; start < a.length; start++) {
            if (start< end) {
             swap(a,start,end);
             end--;
            }
      }
    }

    private static void swap(int[] a ,int x, int y ){
        int temp;
        temp=a[x];
        a[x]=a[y];
        a[y]=temp;
    }
}
