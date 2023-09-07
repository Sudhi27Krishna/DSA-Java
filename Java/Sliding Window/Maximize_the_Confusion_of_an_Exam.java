// Leetcode link => https://leetcode.com/problems/maximize-the-confusion-of-an-exam/

class Maximize_the_Confusion_of_an_Exam {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int i = 0, j = 0, cnt_T = 0, cnt_F = 0, max = 1;

        while(j < n){
            char ch = answerKey.charAt(j);
            if(ch == 'T') cnt_T++;
            else cnt_F++;

            while(Math.min(cnt_T, cnt_F) > k){
                char temp = answerKey.charAt(i);
                if(temp == 'T') cnt_T--;
                else cnt_F--;
                i++;
            }

            max = Math.max(max, j-i+1);
            j++;
        }

        return max;
    }
}
