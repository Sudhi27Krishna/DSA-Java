// InterviewBit link => https://www.interviewbit.com/problems/next-smallest-palindrome/

public class NextSmallestPalindrome {
    public String solve(String A) {
        char[] arr = A.toCharArray();
        int n = arr.length;
        int[] num = new int[n];
        for(int i=0; i<n; i++){
            num[i] = arr[i] - '0';
        }
        
        if(isAll9(num, n)){
            String ans = "1";
            for (int i = 0; i < n - 1; i++)
                ans += "0";
            ans += "1";
            return ans;
        }
        
        fun(num, n);
        String ans = "";
        for(int elm : num) ans += elm;
        return ans;
    }
    
    boolean isAll9(int num[], int n) {
        for (int i = 0; i < n; i++)
            if (num[i] != 9)
                return false;
        return true;
    }
    
    void fun(int[] num, int n){
        int mid = n / 2;
        int i = mid - 1;
        int j = n%2 == 0 ? mid : mid+1;
        
        boolean leftSmaller = false;
        
        while(i >= 0 && num[i] == num[j]){
            i--; j++;
        }
        
        if(i < 0 || num[i] < num[j]) leftSmaller = true;
        
        while(i >= 0) num[j++] = num[i--];
        
        if(leftSmaller){
            int carry = 1;
            
            if(n%2 == 1){
                num[mid]++;
                carry = num[mid] / 10;
                num[mid] %= 10;
            }
            
            i = mid - 1;
            j = n%2 == 0 ? mid : mid+1;
            
            while(i >= 0 && carry > 0){
                num[i] += carry;
                carry = num[i] / 10;
                num[i] %= 10;
                num[j] = num[i];
                i--; j++;
            }
        }
    }
}
