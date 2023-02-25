class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return fun(0, nums, -1, dp);
    }

    int fun(int i, int[] nums, int last, int[][] dp){
        if(i == nums.length) return 0;

        if(dp[i][last+1] != -1) return dp[i][last+1];

        int len = fun(i+1, nums, last, dp);
        if(last == -1 || nums[i] > nums[last]){
            len = Math.max(len, 1 + fun(i+1, nums, i, dp));
        }

        return dp[i][last+1] = len;
    }
}
