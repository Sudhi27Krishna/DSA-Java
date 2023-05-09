// GFG link => https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1

class LongestKUniqueCharactersSubstring {
    public int longestkSubstr(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, n = s.length(), cnt = 0, max = -1;
        
        while(j < n){
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if(map.get(ch) == 1) cnt++;
            
            if(cnt < k){
                j++;
            }
            else if(cnt == k){
                max = Math.max(max, j - i + 1);
                j++;
            }
            else{
                while(cnt > k){
                    char c = s.charAt(i);
                    map.put(c, map.get(c) - 1);
                    if(map.get(c) == 0) cnt--;
                    i++;
                }
                j++;
            }
        }
        
        return max;
    }
}
