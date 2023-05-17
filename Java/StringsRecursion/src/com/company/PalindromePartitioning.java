// Leetcode link => https://leetcode.com/problems/palindrome-partitioning/description/

class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        fun(0, s, new ArrayList<>(), res);
        return res;
    }

    public void fun(int ind, String s, List<String> path, List<List<String>> res){
        if(ind == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=ind; i<s.length(); i++){
            if(isPalindrome(ind, i, s)){
                path.add(s.substring(ind, i+1));
                fun(i+1, s, path, res);
                path.remove(path.size()-1);
            }
        }
    }

    boolean isPalindrome(int start, int end, String str){
        while(start <= end){
            if(str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true;
    }
}
