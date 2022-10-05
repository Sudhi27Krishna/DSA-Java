package com.company;

import java.util.Arrays;

public class GFGSorted2DArrayBinary {
    public static void main(String[] args) {
        int[][] a = {
                { 0, 6, 8, 9, 11 },
                { 20, 22, 28, 29, 31 },
                { 36, 38, 50, 61, 63 },
                { 64, 66, 100, 122, 128 }
        };
        int[][] arr = {
                {1}
        };
        System.out.println(Arrays.toString(seach2(a,128)));
    }
    static int[] findRow(int[][] arr, int target){
        int l = 0;
        int h = arr.length - 1;
        int mid = 0;
        while (l <= h){
            mid = l + (h - l) / 2;
            if(target == arr[mid][0]){
                return new int[]{mid,0};
            }
            if(target == arr[mid][arr[0].length - 1]){
                return new int[]{mid,arr[0].length - 1};
            }
            if(arr[mid][0] < target && target < arr[mid][arr[0].length - 1]){
                return rowBinary(arr,target,mid);
            }
            if(target < arr[mid][0]){
                h = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }

    static int[] rowBinary(int[][] arr, int target, int mid) {
        int s = 0;
        int e = arr[mid].length - 1;
        int m = 0;
        while(s <= e){
            m = s + (e - s) / 2;
            if(arr[mid][m] == target){
                return new int[]{mid,m};
            }
            if(arr[mid][m] > target){
                e = m - 1;
            }else {
                s = m + 1;
            }
        }
        return new int[]{-1,-1};
    }

    static int[] seach2(int[][] matrix, int target){
        int start = 0;
        int end = matrix.length * matrix[0].length - 1;
        int mid = 0;
        int col = matrix[0].length;

        while(start <= end){
            mid = start + (end - start) / 2;
            if(matrix[mid/col][mid%col] == target){
                return new int[]{mid/col,mid%col};
            }

            if(matrix[mid/col][mid%col] < target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return new int[]{-1,-1};
    }
}
