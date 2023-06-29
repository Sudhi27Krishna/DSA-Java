// Leetcode link => https://leetcode.com/problems/distinct-subsequences/description/

class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m][n];
        for(int[] row : dp) Arrays.fill(row, -1);
        return fun(0, 0, s, t, dp);
    }

    int fun(int i, int j, String s, String t, int[][] dp){
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = fun(i+1, j+1, s, t, dp) + fun(i+1, j, s, t, dp);
        }
        return dp[i][j] = fun(i+1, j, s, t, dp);
    }

  // Tabulation
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            dp[i][n] = 1;
        }

        for(int j=0; j<=n-1; j++){
            dp[m][j] = 0;
        }

        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i+1][j+1] + dp[i+1][j];
                }
                else dp[i][j] = dp[i+1][j];
            }
        }

        return dp[0][0];
    }

  // Space Optimized
  public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[] curr = new int[n+1];
        curr[n] = 1;

        for(int i=m-1; i>=0; i--){
            int[] prev = new int[n+1];
            prev[n] = 1;
            for(int j=n-1; j>=0; j--){
                if(s.charAt(i) == t.charAt(j)) {
                    prev[j] = curr[j+1] + curr[j];
                }
                else prev[j] = curr[j];
            }
            curr = prev;
        }

        return curr[0];
    }
}
