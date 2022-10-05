package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        int i;
//        arr[0] = 3;
//        arr[1] = 24;
//        arr[2] = 87;
//        arr[3] = 564;
//        arr[4] = 34;
//        for(i=0;i<arr.length;i++)
//        {
//            arr[i]= in.nextInt();
//        }
//        for(int k:arr)
//        {
//            System.out.print(k+" ");
//        }
//        System.out.println();
//        System.out.println(Arrays.toString(arr));

//        array of objects
        String[] str = new String[4];
        for (i=0;i<str.length;i++)
            str[i] = in.next();

        System.out.println(Arrays.toString(str));
    }
}
