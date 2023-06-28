// Leetcode link => https://leetcode.com/problems/edit-distance/description/

class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];
        for(int[] row : dp) Arrays.fill(row, -1);
        return fun(m-1, n-1, word1, word2, dp);
    }

    public int fun(int i, int j, String str1, String str2, int[][] dp){
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;

        if(dp[i][j] != -1) return dp[i][j];

        if(str1.charAt(i) == str2.charAt(j)) return fun(i-1, j-1, str1, str2, dp);

        return dp[i][j] = Math.min(
            1 + fun(i, j-1, str1, str2, dp), // insert
            Math.min(
                1 + fun(i-1, j, str1, str2, dp), // delete
                1 + fun(i-1, j-1, str1, str2, dp) // replace;
            )
        );
    }

    public int fun_tabulation(String str1, String str2){
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<=n; i++) dp[0][i] = i;
        for(int j=0; j<=m; j++) dp[j][0] = j;

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.min(
                                    1 + dp[i][j-1], // insert
                                    Math.min(
                                        1 + dp[i-1][j], // delete
                                        1 + dp[i-1][j-1] // replace;
                                    )
                                );
                }
            }
        }

        return dp[m][n];
    }

    public int fun_space_opt(String str1, String str2){
        int m = str1.length();
        int n = str2.length();
        int[] prev = new int[n+1];

        for(int i=0; i<=n; i++) prev[i] = i;

        for(int i=1; i<=m; i++){
            int[] curr = new int[n+1];
            curr[0] = i;
            for(int j=1; j<=n; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    curr[j] = prev[j-1];
                }
                else{
                    curr[j] = Math.min(
                                    1 + curr[j-1], // insert
                                    Math.min(
                                        1 + prev[j], // delete
                                        1 + prev[j-1] // replace;
                                    )
                                );
                }
            }
            prev = curr;
        }

        return prev[n];
    }
}
