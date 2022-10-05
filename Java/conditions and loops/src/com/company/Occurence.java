package com.company;

import java.util.Scanner;

public class Occurence {
    public static void main(String[] args) {
           int n=5355656;
        int count=0;

        while (n>0){
            int rem = n%10;
            if(rem==5){
                count++;
            }
            n=n/10;
        }
        System.out.println(count);
    }
}
