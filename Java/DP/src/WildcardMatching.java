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
}
