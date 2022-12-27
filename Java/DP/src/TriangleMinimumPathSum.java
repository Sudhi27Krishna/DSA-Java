// link => https://leetcode.com/problems/triangle/

import java.util.Arrays;
import java.util.List;

public class TriangleMinimumPathSum {
    public int minimumTotal(List<List<Integer>> matrix) {
        int row = matrix.size();
        int[][] dp = new int[row][row];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return fun(0, 0, matrix);
    }

    public int fun(int row, int col, List<List<Integer>> matrix){
        if(row == matrix.size()-1) return matrix.get(row).get(col);

        int down = matrix.get(row).get(col) + fun(row+1, col, matrix);
        int cross = matrix.get(row).get(col) + fun(row+1, col+1, matrix);

        return Math.min(down, cross);
    }

    public int fun_memoize(int row, int col, List<List<Integer>> matrix, int[][] dp){
        if(row == matrix.size()-1) return matrix.get(row).get(col);

        if(dp[row][col] != -1) return dp[row][col];

        int down = matrix.get(row).get(col) + fun_memoize(row+1, col, matrix, dp);
        int cross = matrix.get(row).get(col) + fun_memoize(row+1, col+1, matrix, dp);

        return dp[row][col] = Math.min(down, cross);
    }

    public int fun_tabulation(List<List<Integer>> matrix){
        int row = matrix.size();
        int[][] dp = new int[row][row];

        for (int i = row-1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                if(i == row-1) dp[i][j] = matrix.get(i).get(j);

                else{
                    int down = matrix.get(i).get(j) + dp[i+1][j];
                    int cross = matrix.get(i).get(j) + dp[i+1][j+1];
                    dp[i][j] = Math.min(down, cross);
                }
            }
        }

        return dp[0][0];
    }

    public int fun_sp_opt(List<List<Integer>> matrix){
        int row = matrix.size();
        int[] prev = new int[row];

        for (int i = row-1; i >= 0; i--) {
            int[] curr = new int[row];
            for (int j = i; j >= 0; j--) {
                if(i == row-1) curr[j] = matrix.get(i).get(j);

                else{
                    int down = matrix.get(i).get(j) + prev[j];
                    int cross = matrix.get(i).get(j) + prev[j+1];
                    curr[j] = Math.min(down, cross);
                }
            }
            prev = curr;
        }

        return prev[0];
    }
}
