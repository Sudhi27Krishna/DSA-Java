// InterviewBit link => https://www.interviewbit.com/problems/egg-drop-problem/

public class EggDropProblem {
    int[][] dp;
    public int solve(int e, int f) {
        dp=new int[e+1][f+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return helper(e,f);
    }
    int helper(int e,int f){
        if(f==0|| f==1)
            return f;
        if(e==1)
            return f;
        if(dp[e][f]!=-1)
            return dp[e][f];
        
        int low = 1, high = f, result = f;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int left = helper(e - 1, mid - 1);
            int right = helper(e, f - mid);
            result = Math.min(result, Math.max(left, right) + 1);
            if (left == right) {
                break;
            } else if (left < right) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        dp[e][f] = result;
        return result;
    }


    // Tabulation
    public int solve(int A, int B) {
        // A = eggs; B = floor;
        int[][] dp = new int[A+1][B+1];
        for(int i=0; i<=A; i++){
            dp[i][0] = 1;
            dp[i][1] = 1;
        }
        
        for(int i=0; i<=B; i++) dp[1][i] = i;
        
        for(int e=2; e <= A; e++){
            for(int f=2; f <= B; f++){
                int min = Integer.MAX_VALUE;
                for(int k=1; k<=f; k++){
                    int temp = 1 + Math.max(dp[e-1][k-1], dp[e][f-k]);
                    min = Math.min(min, temp);
                }
                dp[e][f] = min;
            }
        }
        
        
        return dp[A][B];
    }
    
    int fun(int e, int f, int[][] dp){
        if(f == 0 || f == 1) return 1;
        if(e == 1) return f;
        
        if(dp[e][f] != -1) return dp[e][f];
        
        int min = Integer.MAX_VALUE;
        for(int k=1; k<=f; k++){
            int temp = 1 + Math.max(fun(e-1, k-1, dp), fun(e, f - k, dp));
            min = Math.min(min, temp);
        }
        
        return dp[e][f] = min;
    }
}

