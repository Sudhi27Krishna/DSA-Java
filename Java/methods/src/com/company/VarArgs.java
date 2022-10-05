package com.company;

import java.util.Arrays;

public class VarArgs {
    public static void main(String[] args) {
        fun(3,435,434,57,768,87,9,3,45,6);
    }
    static void fun(int ...v){
        System.out.println(Arrays.toString(v));
    }
}
