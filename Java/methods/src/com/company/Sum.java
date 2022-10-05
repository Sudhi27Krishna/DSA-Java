package com.company;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
       sum();
    }
    static void sum()
    {
        Scanner in = new Scanner(System.in);
        int a,b,add;
        System.out.print("Enter the first number: ");
        a=in.nextInt();
        System.out.print("Enter the second number: ");
        b=in.nextInt();
        add=a+b;
        System.out.print("The sum is: " + add);

    }
}
