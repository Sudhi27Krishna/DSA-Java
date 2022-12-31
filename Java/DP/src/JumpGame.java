// link => https://leetcode.com/problems/jump-game/description/

import java.util.Arrays;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return fun_memoize(0, n, nums, dp);
//        return fun(0, n, nums);
    }

    public boolean fun(int ind, int n, int[] nums){
        if(ind == n-1) return true;
        if(nums[ind] == 0) return false;

        boolean result = false;
        for(int i=1; i<=nums[ind]; i++){
            result = result || fun(ind+i, n, nums);
        }

        return result;
    }

    // memoization
    public boolean fun_memoize(int ind, int n, int[] nums, int[] dp){
        if(ind == n-1) return true;
        if(nums[ind] == 0) return false;

        if(dp[ind] != -1) return (dp[ind] == 1);

        boolean result = false;
        for(int i=1; i<=nums[ind]; i++){
            result = result || fun_memoize(ind+i, n, nums, dp);
        }

        dp[ind] = (result) ? 1 : 0;
        return result;
    }

    public boolean fun_tablutaion(int[] nums){
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n-1] = true;
        for (int i = 0; i < n-1; i++) {
            if(nums[i] == 0) dp[i] = false;
        }

        for(int i = n - 2; i >= 0; i--){
            boolean result = false;
            for(int j=1; j<=nums[i]; j++){
                result = result || dp[i+j];
            }

            dp[i] = result;
        }

        return dp[0];
    }
}
