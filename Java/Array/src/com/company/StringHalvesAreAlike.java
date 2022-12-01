// You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.
// Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and 
// lowercase letters.
// Return true if a and b are alike. Otherwise, return false.
class StringHalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        int limit = s.length()/2;
        String one = s.substring(0,limit);
        String two = s.substring(limit, s.length());
        
        return (vowelCount(one) == vowelCount(two));
    }
    
    public int vowelCount(String str){
        int cnt = 0;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            switch(c){
                case 'a':
                case 'A': cnt++;
                    break;
                case 'e':
                case 'E': cnt++;
                    break;
                case 'i':
                case 'I': cnt++;
                    break;
                case 'o':
                case 'O': cnt++;
                    break;    
                case 'u':
                case 'U': cnt++;
                    break;    
            }
        }
        return cnt;
    }
}
