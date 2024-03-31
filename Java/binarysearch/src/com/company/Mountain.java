package com.company;

public class Mountain {
    public static void main(String[] args) {
        int[] arr = {10,26,35,49,67,84,99,6589,76,66,53,26,11};
        System.out.println(Peak(arr));
    }
    static int Peak(int[] a){
        int n = A.length;
        int start = 0, end = n-1;
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            
            if(mid > 0 && mid < n-1){
                if(A[mid-1] > A[mid] && A[mid] < A[mid+1]) return A[mid];
                else if(A[mid-1] < A[mid]) start = mid + 1;
                else end = mid - 1;
            }
            else if(mid == 0){
                return A[mid] < A[mid+1] ? A[mid+1] : A[mid];
            }
            else{
                return A[mid] < A[mid-1] ? A[mid-1] : A[mid];
            }
        }
        
        return A[end];
    }
}
