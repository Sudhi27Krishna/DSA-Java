// Leetcode link => https://leetcode.com/problems/decremental-string-concatenation/description/

class DecrementalStringConcatenation {
    // dp[i][startChar][endChar]: the min add-on len from ith word, given the former existed string with the specific begin char and end char
    Integer[][][] dp; 
    public int minimizeConcatenatedLength(String[] words) {
        int n = words.length;
        dp = new Integer[n][26][26];
        String s = words[0];
        return s.length() + solve(words, 1, s.charAt(0) - 'a', s.charAt(s.length() - 1) - 'a');
    }

    private int solve(String[] words, int i, int startChar, int endChar) {
        if(i >= words.length) return 0;
        if(dp[i][startChar][endChar] != null) return dp[i][startChar][endChar];
        String cur = words[i];
        int len1, len2 = 0; 
   
        // len1: add cur at start
        len1 = cur.length() + solve(words, i + 1, cur.charAt(0) - 'a', endChar);
        if(cur.charAt(cur.length() - 1) - 'a' == startChar) {
            len1 -= 1;
        }

        // len2: add cur at end
        len2 = cur.length() + solve(words, i + 1, startChar, cur.charAt(cur.length() - 1) - 'a');
        if(cur.charAt(0) - 'a' == endChar) {
            len2 -= 1;
        }

        // choose the smaller one of len1 and len2
        return dp[i][startChar][endChar] = Math.min(len1, len2);

    }
}
