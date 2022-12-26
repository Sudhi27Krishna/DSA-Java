// link => https://leetcode.com/problems/unique-paths/description/

import java.util.Arrays;
public class UniquePath_I
{
    public static int uniquePaths(int m, int n) {
        int row = m;
        int col = n;
        int[][] dp = new int[row][col];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        return fun(0, 0, dp);
    }

    public static int fun(int row, int col, int[][] dp){
        if(row == dp.length-1 || col == dp[0].length-1){
            return 1;
        }

        if(dp[row][col] != -1){
            return dp[row][col];
        }

        int down=0, right=0;
        if(row < dp.length-1){
            down = fun(row+1, col, dp);
        }

        if(col < dp[0].length-1){
            right = fun(row, col+1, dp);
        }

        return dp[row][col] = down + right;
    }

    public static int fun_tabulation(int m, int n){
        int[][] dp = new int[m][n];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        for(int i = 0; i < m; i++){
            dp[i][n -1] = 1;
        }
        for(int i = 0; i < n; i++){
            dp[m -1][i] = 1;
        }
        dp[m-1][n-1] = 1;

        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                int down = dp[i+1][j];
                int right = dp[i][j+1];
                dp[i][j] = down + right;
            }
        }
        return dp[0][0];
    }

    public static int fun_sp_opt(int m, int n){
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        dp[m-1] = 1;

        for(int i = n-2; i >= 0; i--){
            for (int j = m-2; j >= 0; j--) {
                dp[j] += dp[j+1];
            }
        }

        return dp[0];
    }
}
