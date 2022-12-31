// link => https://leetcode.com/problems/target-sum/description/

import java.util.Arrays;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int totSum = 0;
        int n = nums.length;
        for(int i=0; i<nums.length;i++){
            totSum += nums[i];
        }

        //Checking for edge cases
        if(totSum-target<0) return 0;
        if((totSum-target)%2==1) return 0;

        int s2 = (totSum-target)/2;

        int dp[][]=new int[n][s2+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);
        return fun_memoize(n-1,s2,nums,dp);
    }

    public int fun_memoize(int ind, int target, int[] nums, int[][] dp){
        if(ind == 0){
            if(target == 0 && nums[0] == 0) return 2;
            else if (target == 0 || nums[0] == target) return 1;
            else return 1;
        }

        if(dp[ind][target]!=-1)
            return dp[ind][target];

        int notTaken = fun_memoize(ind-1,target,nums,dp);

        int taken = 0;
        if(nums[ind]<=target)
            taken = fun_memoize(ind-1,target-nums[ind],nums,dp);

        return dp[ind][target]= (notTaken + taken);
    }

    public int findWays_tabulation(int[] num, int tar){
        int totSum = 0, n = num.length;
        for(int i=0; i<n;i++){
            totSum += num[i];
        }

        //Checking for edge cases
        if(totSum-tar <0 || (totSum-tar)%2==1 ) return 0;

        tar = (totSum-tar)/2;

        int[][] dp=new int[n][tar+1];

        if(num[0] == 0) dp[0][0] =2;  // 2 cases -pick and not pick
        else dp[0][0] = 1;  // 1 case - not pick

        if(num[0]!=0 && num[0]<=tar) dp[0][num[0]] = 1;  // 1 case -pick

        for(int ind = 1; ind<n; ind++){
            for(int target= 0; target<=tar; target++){

                int notTaken = dp[ind-1][target];

                int taken = 0;
                if(num[ind]<=target)
                    taken = dp[ind-1][target-num[ind]];

                dp[ind][target]= (notTaken + taken);
            }
        }
        return dp[n-1][tar];
    }

    public int findTargetSumWays_sp_opt(int[] nums, int target) {
        int totSum = 0, n = nums.length;
        for(int i=0; i<n;i++){
            totSum += nums[i];
        }

        //Checking for edge cases
        if(totSum-target <0 || (totSum-target)%2==1 ) return 0;

        return findWays(nums,(totSum-target)/2);
    }

    public int findWays(int[] num, int tar){
        int n = num.length;
        int[] prev =new int[tar+1];

        if(num[0] == 0) prev[0] =2;  // 2 cases -pick and not pick
        else prev[0] = 1;  // 1 case - not pick

        if(num[0]!=0 && num[0]<=tar) prev[num[0]] = 1;  // 1 case -pick

        for(int ind = 1; ind<n; ind++){
            int[] cur =new int[tar+1];
            for(int target= 0; target<=tar; target++){
                int notTaken = prev[target];

                int taken = 0;
                if(num[ind]<=target)
                    taken = prev[target-num[ind]];

                cur[target]= (notTaken + taken);
            }
            prev = cur;
        }
        return prev[tar];
    }
}
