// GFG link => https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1

class CountOccurencesOfAnagrams {

    int search(String pat, String txt) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<pat.length(); i++){
            char c = pat.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int count = map.size(), ans = 0;
        
        int i = 0, j = 0, n = txt.length(), k = pat.length();
        
        while(j < n){
            char c = txt.charAt(j);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) count--;
            }
            if(j - i + 1 < k){
                j++;
            }
            else if(j - i + 1 == k){
                if(count == 0) ans++;
                char ch_i = txt.charAt(i);
                if(map.containsKey(ch_i)){
                    map.put(ch_i, map.get(ch_i) + 1);
                    if(map.get(ch_i) == 1) count++;
                }
                i++; j++;
            }
        }
        
        return ans;
    }
}
