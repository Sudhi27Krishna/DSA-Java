// Leetcode link => https://leetcode.com/problems/wildcard-matching/description/

class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        Boolean[][] dp = new Boolean[n+1][m+1];
        return fun(0, 0, s, p, dp);
    }

    boolean fun(int i, int j, String s, String p, Boolean[][] dp){
        if(i >= s.length() && j >= p.length()) return true;
        if(i < s.length() && j >= p.length()) return false;

        if(dp[i][j] != null) return dp[i][j];

        if(i >= s.length() && j < p.length()){
            char ch = '*';
            for(int k=j; k<p.length(); k++) if(ch != p.charAt(k)) return false;
            return true;
        }

        if(p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)){
            return dp[i][j] = fun(i+1, j+1, s, p, dp);
        }

        if(p.charAt(j) == '*'){
            return dp[i][j] = fun(i+1, j, s, p, dp) || fun(i, j+1, s, p, dp);
        }

        return dp[i][j] = false;
    }

    // Tabulation
    public boolean isMatchTabulation(String s, String p) {
        int n = s.length(), m = p.length();
        Boolean[][] dp = new Boolean[n+1][m+1];
        dp[n][m] = true;
        for(int i=0; i<n; i++) dp[i][m] = false;

        for(int i=0; i<m; i++){
            char ch = '*';
            for(int k=i; k<p.length(); k++) if(ch != p.charAt(k)){
                dp[n][i] = false;
                break;
            }
            if(dp[n][i] == null) dp[n][i] = true;
        }
        
        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                if(p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                }
                else if(p.charAt(j) == '*'){
                    dp[i][j] = dp[i+1][j] || dp[i][j+1];
                }
                else dp[i][j] = false;
            }
        }
        return dp[0][0];
    }

    // O(1) space complexity
    boolean comparison(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;            
        while (s < str.length()){
            // advancing both pointers
            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }
           // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1){
                p = starIdx + 1;
                match++;
                s = match;
            }
           //current pattern pointer is not star, last patter pointer was not *
          //characters do not match
            else return false;
        }
        
        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;
        
        return p == pattern.length();
    }
}
