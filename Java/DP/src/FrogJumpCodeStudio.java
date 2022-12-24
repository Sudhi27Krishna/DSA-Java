import java.util.Arrays;

public class FrogJumpCodeStudio {
    public static void main(String[] args) {
        int[] height ={30,10,60,10,60,50};
        int n=height.length;
        int[] dp =new int[n];
        Arrays.fill(dp,-1);
    }

    public static int frogJump(int n, int[] heights) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return memoize(dp, n-1, heights);
    }

    public static int memoize(int[] dp, int n, int[] h){
        if(n == 0){
            return 0;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int left = memoize(dp, n-1,h) + Math.abs(h[n] - h[n-1]);
        int right = Integer.MAX_VALUE;
        if(n > 1){
            right = memoize(dp, n-2,h) + Math.abs(h[n] - h[n-2]);
        }

        return dp[n] = Math.min(left, right);
    }

    public static int tabulation(int n, int[] h){
        int[] dp = new int[n];
        Arrays.fill(dp, 0);
        dp[0] = 0;

        for(int i=1; i<n; i++){
            int left = dp[i-1] + Math.abs(h[i] - h[i-1]);
            int right = Integer.MAX_VALUE;
            if(i > 1){
                right = dp[i-2] + Math.abs(h[i] - h[i-2]);
            }

            dp[i] = Math.min(left, right);
        }

        return dp[n-1];
    }

    public static int sp_optimize(int n, int[] h){
        int prev2 = 0;
        int prev1 = 0;

        for(int i=1; i<n; i++){
            int left = prev1 + Math.abs(h[i] - h[i-1]);
            int right = Integer.MAX_VALUE;
            if(i > 1){
                right = prev2 + Math.abs(h[i] - h[i-2]);
            }

            int curr = Math.min(left, right);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
