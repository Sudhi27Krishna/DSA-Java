package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int a,b,c;
        Scanner num = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        a = num.nextInt();
        System.out.print("Enter the second number: ");
        b = num.nextInt();
        c = a + b;
        System.out.println("The sum is " + c);
    }
}
