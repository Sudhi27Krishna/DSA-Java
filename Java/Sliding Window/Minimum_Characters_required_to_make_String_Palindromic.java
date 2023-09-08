// InterviewBit link => https://www.interviewbit.com/problems/minimum-characters-required-to-make-a-string-palindromic/
// InterviewBit link => https://www.interviewbit.com/problems/minimum-appends-for-palindrome/

// Given a string A. The only operation allowed is to insert characters at the beginning of the string.
// Find how many minimum characters are needed to be inserted to make the string a palindrome string.

public class Minimum_Characters_required_to_make_String_Palindromic {
    public int solve(String A) {
        StringBuilder sb = new StringBuilder(A);
        String pat = A + "$" + sb.reverse().toString();
        int[] lps = computeTemporaryArray(pat.toCharArray());
        return A.length() - lps[lps.length-1];
    }
    
    private int[] computeTemporaryArray(char pattern[]){
        int [] lps = new int[pattern.length];
        int index =0;
        for(int i=1; i < pattern.length;){
            if(pattern[i] == pattern[index]){
                lps[i] = index + 1;
                index++;
                i++;
            }else{
                if(index != 0){
                    index = lps[index-1];
                }else{
                    lps[i] =0;
                    i++;
                }
            }
        }
        return lps;
    }
}
