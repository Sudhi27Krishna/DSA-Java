// Leetcode link => https://leetcode.com/problems/minimum-window-substring/description/

class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int i = 0, j = 0, n = s.length(), count = map.size();
        String  ans = "";
        int min = Integer.MAX_VALUE;

        while(j < n){
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) == 0) count--;
            }

            if(count == 0){
                while(count == 0){
                    if(j - i + 1 < min){
                        min = j - i + 1;
                        ans = s.substring(i, j+1);
                    }
                    char c = s.charAt(i);
                    if(map.containsKey(c)){
                        map.put(c, map.get(c) + 1);
                        if(map.get(c) == 1) count++;
                    }
                    i++;
                }
                j++;
            }
            else{
                j++;
            }
        }

        return ans;
    }
}
