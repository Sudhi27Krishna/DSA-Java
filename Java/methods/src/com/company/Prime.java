package com.company;

import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        System.out.println(isPrime(n));
        int a = in.nextInt();
        System.out.println(isArm(a));

    }

    private static boolean isArm(int a ) {
        int count=0;
        int i,rem=0,pro=0,sum=0;
        int c=a;
        int f=a;
        while (a>=0)
        {
           rem =a%10;
           a=a/10;
            count++;
        }
        for(i=0;i<3;i++)
        {
            rem=c%10;
            c=c/10;
            pro = rem*rem*rem;
            sum=sum+pro;

        }
        if(f==sum)
            return true;
        else
            return false;
    }

    private static boolean isPrime(int n) {
        if (n<=1)
            return  false;

            int c=2;
            while(c*c <= n)
            {
                if(n%c == 0)
                {
                    return false;
                }
                c++;

            }
        return c * c > n;

    }

}
