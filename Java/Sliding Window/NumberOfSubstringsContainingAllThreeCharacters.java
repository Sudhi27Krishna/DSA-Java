// Leetcode link => https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/

class NumberOfSubstringsContainingAllThreeCharacters {
    public int numberOfSubstrings(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, ans = 0, n = s.length();

        while(j < n){
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if(map.size() < 3){
                j++;
            }
            else{
                while(map.size() == 3){
                    ans += n - j;
                    map.put(s.charAt(i), map.get(s.charAt(i))-1);
                    if(map.get(s.charAt(i)) == 0) map.remove(s.charAt(i));
                    i++;
                }
                j++;
            }
        }

        return ans;
    }
}
