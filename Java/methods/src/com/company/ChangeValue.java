package com.company;

import java.util.Arrays;

public class ChangeValue {
    public static void main(String[] args) {
        int[] a={2,5,35,78,63};
        change(a);
        System.out.println(Arrays.toString(a));
    }

     static void change(int[] a) {
        a[0]=454;
        
    }
}
