// link => https://leetcode.com/problems/coin-change/description/

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        int ans = fun_memoize(n-1, amount, coins, dp);
        if(ans >= (int)1e9) return -1;
        return ans;
    }
// recursive
    public int fun(int ind, int amt, int[] coins){
        if(ind == 0){
            return (amt%coins[ind] == 0) ? amt/coins[ind] : (int)1e9;
        }


        int notTake = fun(ind-1, amt, coins);
        int take = (int)1e9;
        if(coins[ind] <= amt){
            take = 1 + fun(ind, amt-coins[ind], coins);
        }

        return Math.min(notTake,take);
    }

// memoization
    public int fun_memoize(int ind, int amt, int[] coins, int[][] dp){
        if(ind == 0){
            return (amt%coins[ind] == 0) ? amt/coins[ind] : (int)1e9;
        }

        if(dp[ind][amt] != -1) return dp[ind][amt];

        int notTake = fun_memoize(ind-1, amt, coins, dp);
        int take = Integer.MAX_VALUE;
        if(coins[ind] <= amt){
            take = 1 + fun_memoize(ind, amt-coins[ind], coins, dp);
        }

        return dp[ind][amt] = Math.min(notTake,take);
    }

    // tabulation
    public int coinChange_tabulation(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] arr : dp) Arrays.fill(arr, -1);

        for(int i=0; i<=amount; i++){
            if(i%coins[0] == 0){
                dp[0][i] = i/coins[0];
            }
            else{
                dp[0][i] = (int)1e9;
            }
        }

        for(int ind=1; ind<n; ind++){
            for(int target=0; target<=amount; target++){
                int notTake = dp[ind-1][target];
                int take = (int)1e9;
                if(coins[ind] <= target){
                    take = 1 + dp[ind][target-coins[ind]];
                }

                dp[ind][target] = Math.min(notTake,take);
            }
        }

        int ans = dp[n-1][amount];
        if(ans >= (int)1e9) return -1;
        return ans;
    }

    public int coinChange_sp_opt(int[] coins, int amount){
        int n = coins.length;
        int[] prev = new int[amount+1];

        for(int i=0; i<=amount; i++){
            if(i%coins[0] == 0){
                prev[i] = i/coins[0];
            }
            else{
                prev[i] = (int)1e9;
            }
        }

        for(int ind=1; ind<n; ind++){
            int[] curr = new int[amount+1];
            for(int target=0; target<=amount; target++){
                int notTake = prev[target];
                int take = (int)1e9;
                if(coins[ind] <= target){
                    take = 1 + curr[target-coins[ind]];
                }

                curr[target] = Math.min(notTake,take);
            }
            prev = curr;
        }

        int ans = prev[amount];
        if(ans >= (int)1e9) return -1;
        return ans;
    }
}
