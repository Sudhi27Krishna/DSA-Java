package com.company;

import java.util.Scanner;

public class CaseCheck {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char ch = 'A';
        int num = ch;
        while (num<='z'){
        System.out.println(num+"-"+ ch);
        num+=1;
        ch+=1;}
    }
}
