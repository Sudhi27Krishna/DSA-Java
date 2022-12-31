// Code Studio

public class LongestCommonSubstring {
    public static void main(String[] args) {
        printLCSubstring("abfgcjkgnde", "abjucjkgscvde");
    }

    public static void printLCSubstring(String text1, String text2){
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

        int lcs_max_len = 0;
        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    lcs_max_len = Math.max(lcs_max_len, dp[i][j]);
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        int i = n1, j = n2;
        while (i > 0 && j > 0){
            if(dp[i][j] != 0){
                ans.append(text1.charAt(i-1));
            }
            else {
                ans = new StringBuilder();
            }
            i--; j--;
        }

        ans.reverse();
        System.out.println(ans.toString()+" "+lcs_max_len);
    }
}
