// link => https://leetcode.com/problems/coin-change-ii/description/

import java.util.Arrays;

public class CoinChangeII {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return fun(n-1, amount, coins);
    }

    public int fun(int ind, int target, int[] coins){
        if(ind == 0){
            return (target%coins[ind] == 0) ? 1 : 0;
        }

        int notTake = fun(ind-1, target, coins);
        int take = 0;
        if(coins[ind] <= target){
            take = fun(ind, target-coins[ind], coins);
        }

        return take + notTake;
    }

    public int fun_memoize(int ind, int target, int[] coins, int[][] dp){
        if(ind == 0){
            return (target%coins[ind] == 0) ? 1 : 0;
        }

        if(dp[ind][target] != -1) return dp[ind][target];

        int notTake = fun_memoize(ind-1, target, coins, dp);
        int take = 0;
        if(coins[ind] <= target){
            take = fun_memoize(ind, target-coins[ind], coins, dp);
        }

        return dp[ind][target] = take + notTake;
    }

    public int fun_tabulaion(int target, int[] coins){
        int n = coins.length;
        int[][] dp = new int[n][target+1];
        for(int[] row : dp){
            Arrays.fill(row, 0);
        }

        for (int i = 0; i <= target; i++) {
            if(i%coins[0] == 0) dp[0][i] = 1;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int tar = 0; tar <= target; tar++){
                int notTake = dp[ind-1][tar];
                int take = 0;
                if(coins[ind] <= tar){
                    take = dp[ind][tar-coins[ind]];
                }

                dp[ind][tar] = take + notTake;
            }
        }

        return dp[n-1][target];
    }

    public int fun_sp_opt(int target, int[] coins){
        int n = coins.length;
        int[] prev = new int[target+1];

        for (int i = 0; i <= target; i++) {
            if(i%coins[0] == 0) prev[i] = 1;
            else prev[i] = 0;
        }

        for (int ind = 1; ind < n; ind++) {
            int[] curr = new int[target+1];
            for (int tar = 0; tar <= target; tar++){
                int notTake = prev[tar];
                int take = 0;
                if(coins[ind] <= tar){
                    take = curr[tar-coins[ind]];
                }

                curr[tar] = take + notTake;
            }
            prev = curr;
        }

        return prev[target];
    }

    public int change_knapsack1D(int target, int[] coins) {
        int n = coins.length;
        int[] prev = new int[target+1];

        for (int i = 0; i <= target; i++) {
            if(i%coins[0] == 0) prev[i] = 1;
            else prev[i] = 0;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int tar = 0; tar <= target; tar++){
                int notTake = prev[tar];
                int take = 0;
                if(coins[ind] <= tar){
                    take = prev[tar-coins[ind]];
                }

                prev[tar] = take + notTake;
            }
        }

        return prev[target];
    }
}
