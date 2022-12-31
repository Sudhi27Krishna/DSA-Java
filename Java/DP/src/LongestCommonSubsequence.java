// link => https://leetcode.com/problems/longest-palindromic-subsequence/description/

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(printLCS("abcdge", "bdgek"));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1][n2];
        for(int[] row : dp) Arrays.fill(row, -1);
        return fun_memoize(n1-1, n2-1, text1, text2, dp);
//        return fun(n1-1, n2-1, text1, text2);
    }

    public int fun(int ind1, int ind2, String str1, String str2){
        if(ind1 < 0 || ind2 < 0) return 0;

        if(str1.charAt(ind1) == str2.charAt(ind2)){
            return 1 + fun(ind1-1, ind2-1, str1, str2);
        }

        return Math.max(fun(ind1-1, ind2, str1, str2), fun(ind1, ind2-1, str1, str2));
    }

    public int fun_memoize(int ind1, int ind2, String str1, String str2, int[][] dp){
        if(ind1 < 0 || ind2 < 0) return 0;

        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];

        if(str1.charAt(ind1) == str2.charAt(ind2)){
            return 1 + fun_memoize(ind1-1, ind2-1, str1, str2, dp);
        }

        return dp[ind1][ind2] = Math.max(fun_memoize(ind1-1, ind2, str1, str2, dp), fun_memoize(ind1, ind2-1, str1, str2, dp));
    }

    public int fun_tabulation(String text1, String text2){
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1+1][n2+1];

        // Shifting indexes to right one 1, ie index=>imply 0=>-1, 1=>0,2=>1
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= n2; i++) {
            dp[0][i] = 0;
        }

        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }

    public int fun_sp_opt(String text1, String text2){
        int n1 = text1.length();
        int n2 = text2.length();
        int[] prev = new int[n2+1];

        for (int i = 0; i <= n2; i++) {
            prev[i] = 0;
        }

        for(int i=1; i<=n1; i++){
            int[] curr = new int[n2+1];
            for(int j=1; j<=n2; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                }
                else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            prev = curr;
        }
        return prev[n2];
    }

    // Print Longest Common Subsequence using tabulation method
    public static String printLCS(String text1, String text2){
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1+1][n2+1];

        // Shifting indexes to right one 1, ie index=>imply 0=>-1, 1=>0,2=>1
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= n2; i++) {
            dp[0][i] = 0;
        }

        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        int i = n1, j = n2;
        while (i > 0 && j > 0){
            if(dp[i][j-1] == dp[i-1][j]){
                ans.append(text1.charAt(i-1));
                i--; j--;
            }
            else if (dp[i][j-1] > dp[i-1][j]) {
                j--;
            }
            else{
                i--;
            }
        }

        ans.reverse();
        return ans.toString();
    }
}
