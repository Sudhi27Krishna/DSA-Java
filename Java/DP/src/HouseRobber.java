// Leetcode link => https://leetcode.com/problems/house-robber/
// Code Studio => Maximum sum of non-adjacent elements

import java.util.* ;
public class HouseRobber {
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int[] dp = new int[nums.size()];
        Arrays.fill(dp, -1);
        dp[0] = nums.get(0);
        return fun(dp, nums, nums.size()-1);
    }

    public static int fun(int[] dp, ArrayList<Integer> nums, int ind){
        if(ind == 0){
            return nums.get(0);
        }

        if(ind < 0){
            return 0;
        }

        if(dp[ind] != -1){
            return dp[ind];
        }

        int left = nums.get(ind) + fun(dp, nums, ind - 2);
        int right = fun(dp, nums, ind - 1);

        return dp[ind] = Math.max(left, right);
    }

    public static int maximumNonAdjacentSumTabulation(ArrayList<Integer> nums) {
        int[] dp = new int[nums.size()];
        dp[0] = nums.get(0);
        for(int i=1; i<nums.size(); i++){
            int take=0, notTake=0;
            if(i > 1){
                take = nums.get(i) + dp[i-2];
            }
            else{
                take = nums.get(i);
            }
            notTake = dp[i-1];
            dp[i] = Math.max(take, notTake);
        }
        return dp[nums.size()-1];
    }

    public static int maximumNonAdjacentSum_sp_opt(ArrayList<Integer> nums) {
        int prev2 = 0;
        int prev1 = nums.get(0);

        for(int i=1; i<nums.size(); i++){
            int pick = nums.get(i);
            if(i > 1){
                pick += prev2;
            }
            int notPick = prev1;
            int curr = Math.max(pick, notPick);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }


    // Circular Houses
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int n = nums.length;
        ArrayList<Integer> temp1 = new ArrayList<>();
        ArrayList<Integer> temp2 = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(i != 0){
                temp1.add(nums[i]);
            }

            if(i != n-1){
                temp2.add(nums[i]);
            }
        }
        return Math.max(fun2(temp1), fun2(temp2));
    }

    public int fun2(ArrayList<Integer> arr){
        int n = arr.size();
        int prev = arr.get(0);
        int prev2 =0;

        for(int i=1; i<n; i++){
            int pick = arr.get(i);
            if(i>1)
                pick += prev2;
            int nonPick = prev;

            int cur_i = Math.max(pick, nonPick);
            prev2 = prev;
            prev= cur_i;

        }
        return prev;
    }
}