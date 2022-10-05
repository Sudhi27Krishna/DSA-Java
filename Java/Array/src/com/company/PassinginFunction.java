package com.company;

import java.util.Arrays;

public class PassinginFunction {
    public static void main(String[] args) {
        int[] num = {3,45,46,657,56};
        System.out.println(Arrays.toString(num));
        change(num);
        System.out.println(Arrays.toString(num));
}

    private static void change(int[] arr) {
      arr[3]=0;
    }


}
