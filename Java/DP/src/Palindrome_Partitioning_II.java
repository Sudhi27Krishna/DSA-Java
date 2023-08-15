// Leetcode link => https://leetcode.com/problems/palindrome-partitioning-ii/description/

class Palindrome_Partitioning_II
 {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return fun(0, s, dp) - 1;
    }

    int fun(int ind, String s, int[] dp){
        if(ind == s.length()) return 0;

        if(dp[ind] != -1) return dp[ind];

        int min = Integer.MAX_VALUE;
        for(int i=ind; i<s.length(); i++){
            if(isPal(s, ind, i)){
                int cost = 1 + fun(i+1, s, dp);
                min = Math.min(min, cost);
            }
        }

        return dp[ind] = min;
    }

   // Tabulation
   public int minCut_tab(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 0;

        for(int i=n-1; i>=0; i--){
            int min = Integer.MAX_VALUE;
            for(int j=i; j<s.length(); j++){
                if(isPal(s, i, j)){
                    int cost = 1 + dp[j+1];
                    min = Math.min(min, cost);
                }
            }
            dp[i] = min;
        }

        return dp[0] - 1;
    }

    boolean isPal(String str, int start, int end){
        while(start < end){
            if(str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true;
    }

   // Leetcode AC solution
   private Integer dp[][];
    private Boolean dpIsPalindrome[][];
    public int minCut(String s) {
        dp = new Integer[s.length()][s.length()];
        dpIsPalindrome = new Boolean[s.length()][s.length()];
        return minCutFrom(s, 0, s.length() - 1);
    }
    
    private int minCutFrom(String s, int start, int end) {
        if (start == end || isPalindrome(s, start, end)) {
            return 0;
        }
        
        if (dp[start][end] != null)
            return dp[start][end];
        
        int minCut = s.length() - 1;
        for (int i = start; i <= end; i++) {
            if (isPalindrome(s, start, i)) {
                minCut = Math.min(minCut, 1 + minCutFrom(s, i + 1, end));
            }
        }
        return dp[start][end] = minCut;
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        if (start >= end)
            return true;
        
        if (dpIsPalindrome[start][end] != null)
            return dpIsPalindrome[start][end];
        
        return dpIsPalindrome[start][end] = (s.charAt(start) == s.charAt(end))
            && isPalindrome(s, start + 1, end - 1);
    }
}
