package com.company;

import java.util.Scanner;

public class Roman {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int[] a = new int[s.length()];
        int i;
        for(i=0;i<s.length();i++){
            if(s.charAt(i) == 'I')
                a[i] = 1;
             if(s.charAt(i) == 'V')
                a[i] = 5;
             if(s.charAt(i) == 'X')
                a[i] = 10;
             if(s.charAt(i) == 'L')
                a[i] = 50;
             if(s.charAt(i) == 'C')
                a[i] = 100;
             if(s.charAt(i) == 'D')
                a[i] = 500;
             if(s.charAt(i) == 'M')
                a[i] = 1000;
        }
        int sum1 = 0;
        for(i=0;i<a.length;i++){
            if(i<a.length-1 && a[i]<a[i+1]){
                int sum2 = a[i+1] - a[i];
                sum1 += sum2;
                i++;
            }
            else{
                sum1 += a[i];
            }
        }
        System.out.println(sum1);
    }
}




