// link => https://leetcode.com/problems/unique-paths-ii/

import java.util.Arrays;

public class UniquePaths_II {
    public int uniquePathsWithObstacles(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return fun_memoize(row-1, col-1, matrix, dp);
    }

    public int fun(int row, int col, int[][] matrix){ // Simple Recursion
        if(row < 0 || col < 0 || matrix[row][col] == 1) return 0;

        if(row == 0 && col == 0) return 1;

        int up = fun(row-1, col, matrix);
        int left = fun(row, col-1, matrix);

        return up + left;
    }
    public int fun_memoize(int row, int col, int[][] matrix, int[][] dp){
        if(row < 0 || col < 0 || matrix[row][col] == 1 || matrix[0][0] == 1) return 0;
        if(dp[row][col] != -1) return dp[row][col];

        if(row == 0 && col == 0) return 1;

        int up = fun_memoize(row-1, col, matrix, dp);
        int left = fun_memoize(row, col-1, matrix, dp);

        return dp[row][col] = up + left;
    }

    public int uniquePathsWithObstacles_tabulation(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j] == 1) dp[i][j] = 0;
                else if(i == 0 && j == 0) dp[i][j] = 1;
                else{
                    int left = 0, up = 0;
                    if(j > 0) left = dp[i][j-1];
                    if(i > 0) up = dp[i-1][j];
                    dp[i][j] = up + left;
                }
            }
        }

        return dp[row-1][col-1];
    }

    public int uniquePathsWithObstacles_sp_opt(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] curr = new int[col];
        int[] prev = new int[col];
        Arrays.fill(curr, -1);
        Arrays.fill(prev, -1);

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j] == 1) curr[j] = 0;
                else if(i == 0 && j == 0) curr[j] = 1;
                else{
                    int left = 0, up = 0;
                    if(j > 0) left = curr[j-1];
                    if(i > 0) up = prev[j];
                    curr[j] = up + left;
                }
            }

            prev = curr;
        }

        return prev[col-1];
    }
}
