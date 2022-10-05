package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class FirstLast {
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
        int[] out = binary(arr,key,n);
        System.out.println(Arrays.toString(out));

    }
    static int[] binary(int[] nums,int target,int n)
    {
        int[] res = {-1,-1};
        res[0]= binary_again(nums,target,n,true);
        if(res[0] != -1){
        res[1]= binary_again(nums,target,n,false);}
        return res;

    }
    static int binary_again(int[] nums,int target,int n,boolean findStartIndex)
    {

           int ans=-1;
            int start = 0;
            int end = n - 1;
            int mid;
            while(start<=end)
            {
                mid = start + (end-start)/2;
                if(target<nums[mid])
                {
                    end = mid - 1;
                }
                else if (target>nums[mid])
                {
                    start = mid + 1;
                }
                else
                {
                    ans = mid;
                    if (findStartIndex)
                        end = mid - 1;
                    else
                        start = mid + 1;
                }
            }
            return ans;

    }
}
