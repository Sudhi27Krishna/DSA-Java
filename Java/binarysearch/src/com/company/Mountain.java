package com.company;

public class Mountain {
    public static void main(String[] args) {
        int[] arr = {10,26,35,49,67,84,99,6589,76,66,53,26,11};
        System.out.println(Peak(arr));
    }
    static int Peak(int[] a){
        int start = 0;
        int end = a.length - 1;
        int mid;
        while(start < end)
        {
            mid = start + (end-start)/2;
            if(a[mid] > a[mid+1]){
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        return a[start]; // or return end; since start == end
    }
}