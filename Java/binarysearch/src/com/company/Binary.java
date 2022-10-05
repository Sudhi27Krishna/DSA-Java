package com.company;

import java.util.Scanner;

public class Binary {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        int[] arr = new int[50];
        System.out.println("Enter the size: ");
         n = in.nextInt();
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
           arr[i]=in.nextInt();
        }
        int key;
        System.out.println("Enter the target element: ");
        key=in.nextInt();
        int ans = binary(arr,key,n);
        System.out.println(ans);
    }
    static int binary(int[] a,int target,int n)
    {
        int start = 0;
        int end = n - 1;
        int mid;
        while(start<=end)
        {
             mid = start + (end-start)/2;
             if(target<a[mid])
             {
                end = mid - 1;
             }
            else if (target>a[mid])
            {
                start = mid + 1;
            }
                     else
                     {
                         return mid;
                     }
        }
         return -1;
    }
}
