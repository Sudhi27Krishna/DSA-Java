// Leetcode link > https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
// contains solution using queue in solutions section on leetcode

class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, n = s.length(), max = 0;

        while(j < n){
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            
            if(map.size() == j - i + 1){
                max = Math.max(max, j - i + 1);
                j++;
            }
            else if(map.size() < j - i + 1){
                while(map.size() < j - i + 1){
                    char c = s.charAt(i);
                    map.put(c, map.get(c) - 1);
                    if(map.get(c) == 0) map.remove(c);
                    i++;
                }
                j++;
            }
        }

        return max;
    }
}
