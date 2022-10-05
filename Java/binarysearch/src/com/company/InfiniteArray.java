package com.company;

import java.util.Scanner;

public class InfiniteArray {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int i,n;
        int[] arr = {10,26,35,49,67,84,99,152,365,452};
//        System.out.println("Enter the size: ");
//        n = in.nextInt();
//        System.out.println("Enter the elements: ");
//        for ( i = 0; i < n; i++) {
//            arr[i]=in.nextInt();
//        }
        int key = 99;
//        int answer = -1;
//        System.out.println("Enter the target element: ");
//        key=in.nextInt();
        System.out.println(ans(arr,key));

    }
    static int ans (int[] array,int task){
        int start = 0;
        int end = 1;
        while (task > array[end]){
            int newStart = end  + 1;
             end = end  + (end - start + 1) * 2;
             start = newStart;
        }
        return binary(array,task,start,end);
    }
    static int binary(int[] a,int target,int start,int end)
    {

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
