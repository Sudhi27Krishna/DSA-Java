// link => https://leetcode.com/problems/minimum-path-sum/

import java.util.Arrays;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

//        return fun(row-1, col-1, grid);
        int[][] dp = new int[row][col];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        dp[0][0] = grid[0][0];
        return fun_memoize(row-1, col-1, grid, dp);
    }

    public int fun(int row, int col, int[][] grid){
        if(row < 0 || col < 0) return Integer.MAX_VALUE;

        if(row == 0 && col == 0) return grid[0][0];

        int up = fun(row-1, col, grid);
        int left = fun(row, col-1, grid);

        return grid[row][col] + Math.min(left, up);
    }

    public int fun_memoize(int row, int col, int[][] grid, int[][] dp){
        if(row < 0 || col < 0) return Integer.MAX_VALUE;

        if(row == 0 && col == 0) return dp[0][0];

        if(dp[row][col] != -1) return dp[row][col];

        int up = fun_memoize(row-1, col, grid, dp);
        int left = fun_memoize(row, col-1, grid, dp);

        return dp[row][col] = grid[row][col] + Math.min(left, up);
    }

    public int fun_tabulatio(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(i == 0 && j == 0){
                    dp[i][j] = grid[0][0];
                }
                else{
                    int left = Integer.MAX_VALUE;
                    int up = Integer.MAX_VALUE;
                    if(j > 0){
                        left = dp[i][j-1];
                    }
                    if(i > 0){
                        up = dp[i-1][j];
                    }
                    dp[i][j] = grid[i][j] + Math.min(left, up);
                }
            }
        }

        return dp[row-1][col-1];
    }

    public int fun_sp_opt(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;

        int[] prev = new int[col];
        Arrays.fill(prev, 0);

        for (int i = 0; i < row; i++) {
            int[] curr = new int[col];
            for (int j = 0; j < col; j++) {
                if(i == 0 && j == 0){
                    prev[0] = grid[0][0];
                }
                else{
                    int left = Integer.MAX_VALUE;
                    int up = Integer.MAX_VALUE;
                    if(j > 0){
                        left = curr[j-1];
                    }
                    if(i > 0){
                        up = prev[j];
                    }
                    curr[j] = grid[i][j] + Math.min(left, up);
                }
            }
            prev = curr;
        }

        return prev[col-1];
    }
}
