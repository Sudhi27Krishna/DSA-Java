package com.company;

public class RBS {
    public static void main(String[] args) {
       int[] arr = {4,5,6,7,0,1,2};
        System.out.println(findPivot(arr));
    }
    static int binaryPivot(int[] a, int target){
        int pivot = findPivot(a);
//        if no pivot then do normal binary search
        if(pivot == -1){
            return binary(a,target,0,a.length - 1);
        }
        if(a[pivot] == target){
            return target;
        }
        if(target >= a[0]){
            return binary(a,target,0,pivot - 1);
        }else{
            return binary(a,target,pivot + 1,a.length - 1);
        }
    }
    static int binary(int[] a,int target,int start,int end)
    {
        while(start<=end)
        {
            int mid = start + (end-start)/2;
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
    static int findPivot(int[] a){
        int start = 0;
        int end = a.length - 1;
        while(start < end){
            int mid = start + (end-start)/2;
//            4 cases
            if(mid < end && a[mid] > a[mid + 1]){
                return mid;
            }
            if (mid > start && a[mid - 1] > a[mid]){
                return mid -1;
            }
            if(a[mid] <= a[start]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
}
