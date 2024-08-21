// Leetcode link => https://leetcode.com/problems/burst-balloons/

class BurstBalloons {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len+2];
        arr[0] = 1;
        arr[len+1] = 1;
        for(int i=1; i<=len; i++){
            arr[i] = nums[i-1];
        }
        int[][] dp = new int[arr.length+1][arr.length+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return fun(1, len, arr, dp);
    }

    int fun(int i, int j, int[] nums, int[][] dp){
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int res = Integer.MIN_VALUE;
        for(int ind=i; ind<=j; ind++){
            int cost = nums[i-1] * nums[ind] * nums[j+1] + fun(i, ind-1, nums, dp) + 
                    fun(ind+1, j, nums, dp);
            res = Math.max(res, cost);
        }

        return dp[i][j] =  res;
    }
}
