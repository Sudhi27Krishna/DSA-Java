package com.company;

import java.util.Scanner;

public class SmallLetter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[100];
        System.out.println("Enter the size: ");
        int n = in.nextInt();
        System.out.println("Enter the char array elements: ");
        for(int i = 0;i<n;i++)
        {
            char c = in.next().charAt(0);
            arr[i] = c;
        }
        System.out.println("Enter the target: ");
        char k = in.next().charAt(0);
        int ans = binary(arr,k,n);
        char s = (char) ans;
        System.out.println(s);
    }
    static int binary(int[] a,int target,int n)
    {

            int start = 0;
            int end = n - 1;
            int mid = 0;
            while (start <= end) {
                mid = start + (end - start) / 2;
                if (target < a[mid]) {
                    end = mid - 1;
                } else  {
                    start = mid + 1;
                }
            }
            return a[start % n];
//        if(target<a[mid])
//            return a[mid];
//        else
//            return a[mid+1];
        }

}
