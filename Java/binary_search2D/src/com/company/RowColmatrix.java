package com.company;

import java.util.Arrays;

public class RowColmatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {10,20,30,40},
                {21,26,35,42},
                {32,33,34,45}
        };
        System.out.println(Arrays.toString(search(arr,20)));
    }
    static int[] search(int[][] matrix,int target){
        int r = 0;
        int c = matrix[0].length - 1;
        while(r < matrix.length && c >= 0){
            if(matrix[r][c] == target){
                return new int[]{r,c};
            }
            if(matrix[r][c] < target){
                r++;
            }else{
                c--;
            }
        }
        return new int[]{-1,-1};
    }
}
