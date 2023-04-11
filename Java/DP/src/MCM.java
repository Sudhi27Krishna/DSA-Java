// CodeStudio Matrix Chain Multiplication problem

import java.util.Arrays;

public class MCM {
    public static int matrixMultiplication(int[] arr , int N) {
        int[][] dp = new int[N][N];
        for(int[] row : dp) Arrays.fill(row, -1);
        return fun_memoize(1, arr.length-1, arr, dp);
    }

    public static int fun(int i, int j, int[] arr){
        if(i == j) return 0;


        int min = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int steps = (arr[i-1]*arr[k]*arr[j]) + fun(i, k, arr) + fun(k+1, j, arr);
            min = Math.min(min, steps);
        }

        return min;
    }


    // Memoization
    public static int fun_memoize(int i, int j, int[] arr, int[][] dp){
        if(i == j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int steps = (arr[i-1]*arr[k]*arr[j]) + fun_memoize(i, k, arr, dp) + fun_memoize(k+1, j, arr, dp);
            min = Math.min(min, steps);
        }

        return dp[i][j] = min;
    }
    
    // Tabulation
    public static int matrixMultiplication_tabulation(int[] arr , int N) {
        int[][] dp = new int[N][N];
        for(int i=1; i<N; i++){
            dp[i][i] = 0;
        }

        for(int i=N-1; i>=1 ; i--){
            for(int j=i+1; j<=N-1; j++){
                int min = Integer.MAX_VALUE;
                for(int k=i; k<j; k++){
                    int steps = (arr[i-1]*arr[k]*arr[j]) + dp[i][k] + dp[k+1][j];
                    min = Math.min(min, steps);
                }
                dp[i][j] = min;
            }
        }

        return dp[1][N-1];
    }
}
