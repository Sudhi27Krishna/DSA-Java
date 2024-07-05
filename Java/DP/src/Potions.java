// Interviewbit link => https://www.interviewbit.com/problems/potions/

public class Potions {
    public int minSmoke(int[] A) {
        int n = A.length;
        int[] prefix = new int[n+1];
        prefix[0] = 0;
        for(int i=1; i<n+1; i++){
            prefix[i] = A[i-1] + prefix[i-1];
        }
        
        int[][] dp = new int[n][n];
        for(int[] row : dp) Arrays.fill(row, -1);
        return fun(0, n-1, A, prefix, dp);
    }
    
    int fun(int i, int j, int[] A, int[] prefix, int[][] dp){
        if(i >= j) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int res = (int)1e7;
        for(int k=i; k<j; k++){
            int x = (prefix[k+1] - prefix[i]) % 100;
            int y = (prefix[j+1] - prefix[k+1]) % 100;
            int gasCost = x * y;
            res = Math.min(res, gasCost + fun(i, k, A, prefix, dp) + fun(k+1, j, A, prefix, dp));
        }
        
        return dp[i][j] = res;
    }
}
