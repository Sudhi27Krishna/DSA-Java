package com.company;

import java.util.Scanner;

public class ceiling {
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
        if(target>a[a.length - 1])
            return -1;
        else {
            int start = 0;
            int end = n - 1;
            int mid = 0;
            while (start <= end) {
                mid = start + (end - start) / 2;
                if (target < a[mid]) {
                    end = mid - 1;
                } else if (target > a[mid]) {
                    start = mid + 1;
                } else {
                    return a[mid];
                }
            }
            return a[start];
//        if(target<a[mid])
//            return a[mid];
//        else
//            return a[mid+1];
        }
    }
}
