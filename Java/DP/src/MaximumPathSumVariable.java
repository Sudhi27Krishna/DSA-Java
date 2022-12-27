// CodeStudio question

import java.util.Arrays;

public class MaximumPathSumVariable {
    public static int getMaxPathSum(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<matrix[0].length; i++){
            int ans = fun(0, i, matrix);
            max = Math.max(max, ans);
        }
        return max;
    }

    public static int fun(int row, int col, int[][] matrix){
        if(col < 0 || col == matrix[0].length-1) return 0;
        if(row == matrix.length-1) return matrix[row][col];

        int dleft = fun(row+1, col-1, matrix);
        int down = fun(row+1, col, matrix);
        int dright = fun(row+1, col+1, matrix);

        return matrix[row][col] + Math.max(dleft, Math.max(down, dright));
    }

    public static int fun_memoize(int row, int col, int[][] matrix, int[][] dp){
        if(col < 0 || col == matrix[0].length-1) return 0;
        if(row == matrix.length-1) return matrix[row][col];

        if(dp[row][col] != -1) return dp[row][col];

        int dleft = fun_memoize(row+1, col-1, matrix, dp);
        int down = fun_memoize(row+1, col, matrix, dp);
        int dright = fun_memoize(row+1, col+1, matrix, dp);

        return dp[row][col] = matrix[row][col] + Math.max(dleft, Math.max(down, dright));

    }

    public static int fun_tabulation(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];

        for(int i=0; i<col; i++){
            dp[row-1][i] = matrix[row-1][i];
        }

        for (int i = row-2; i >= 0; i--) {
            for (int j = col-1; j >= 0; j--) {
                int down = Integer.MIN_VALUE, dleft = Integer.MIN_VALUE, dright = Integer.MIN_VALUE;

                if(j > 0) dleft = dp[i+1][j-1];
                if(j < col-1) dright = dp[i+1][j+1];
                down = dp[i+1][j];

                dp[i][j] = matrix[i][j] + Math.max(dleft, Math.max(down, dright));
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<col; i++){
            int ans = dp[0][i];
            max = Math.max(ans, max);
        }

        return max;
    }

    public static int fun_sp_opt(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        int[] prev = new int[col];

        for(int i=0; i<col; i++){
            prev[i] = matrix[row-1][i];
        }

        for (int i = row-2; i >= 0; i--) {
            int[] curr = new int[col];
            for (int j = col-1; j >= 0; j--) {
                int down = Integer.MIN_VALUE, dleft = Integer.MIN_VALUE, dright = Integer.MIN_VALUE;

                if(j > 0) dleft = prev[j-1];
                if(j < col-1) dright = prev[j+1];
                down = prev[j];

                curr[j] = matrix[i][j] + Math.max(dleft, Math.max(down, dright));
            }
            prev = curr;
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<col; i++){
            int ans = prev[i];
            max = Math.max(ans, max);
        }
        return max;
    }
}
