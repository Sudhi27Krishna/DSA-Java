// Leetcode link => https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/

class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp=new int[n];
        int[] cnt=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(cnt,1);
        int max = 1;
        
        for(int i=0; i<=n-1; i++){
            for(int prev_index = 0; prev_index < i; prev_index++){
                if(nums[prev_index] < nums[i] && 1 + dp[prev_index] > dp[i]){
                    dp[i] = 1 + dp[prev_index];
                    cnt[i] = cnt[prev_index];
                }
                else if(nums[prev_index] < nums[i] && 1 + dp[prev_index] == dp[i]){
                    dp[i] = 1 + dp[prev_index];
                    cnt[i] += cnt[prev_index];
                }
            }
            max = Math.max(max, dp[i]);
        }

        int nos = 0;
        for(int i=0; i<n; i++){
            if(dp[i] == max) nos += cnt[i];
        }
        return nos;
    }
}
