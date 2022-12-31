// link => https://leetcode.com/problems/jump-game-ii/description/

class JumpGameII {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return fun(0, n, nums, dp) - 1;
    }

    public int fun(int ind, int n, int[] nums, int[] dp){
        if(ind >= n-1) return 1;
        if(nums[ind] == 0) return (int)1e9;

        if(dp[ind] != -1) return dp[ind];

        int min = (int)1e9;
        for(int i=1; i<=nums[ind]; i++){
            int ans = fun(ind+i, n, nums, dp);
            min = Math.min(min, ans);
        }

        return dp[ind] =  min + 1;
    }
}
