package com.company;

public class SplitArray {
    public static void main(String[] args) {
        int[] arr = {7,2,5,8,10};
        System.out.println(Split(arr,2));
    }
    static int Split(int[] a,int m) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < a.length; i++) {
            start = Math.max(start, a[i]);
            end += a[i];
        }
        int pieces = 0;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int sum = 0;
            pieces = 1;
            for (int num : a) {
                if (sum + num > mid) {
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }
            if (pieces > m) {
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return end;
    }
}
