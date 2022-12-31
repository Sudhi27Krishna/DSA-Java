// Code Studio

import java.util.Arrays;

public class UnboundedKnapsack {

    static int unboundedKnapsack(int n, int W, int[] val,int[] wt) {

        int[][] dp=new int[n][W+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);
        return knapsackUtil(wt, val, n-1, W, dp);
    }

    static int knapsackUtil(int[] wt,int[] val, int ind, int W,int[][] dp){

        if(ind == 0){
            return ((int)(W/wt[0])) * val[0];
        }

        if(dp[ind][W]!=-1)
            return dp[ind][W];

        int notTaken = knapsackUtil(wt, val, ind - 1, W, dp);

        int taken = Integer.MIN_VALUE;
        if(wt[ind] <= W)
            taken = val[ind] + knapsackUtil(wt,val,ind,W-wt[ind],dp);

        return dp[ind][W] = Math.max(notTaken,taken);
    }

    static int unboundedKnapsack_tabulation(int n, int W, int[] val,int[] wt) {

        int[][] dp=new int[n][W+1];

        //Base Condition

        for(int i=wt[0]; i<=W; i++){
            dp[0][i] = ((int) i/wt[0]) * val[0];
        }

        for(int ind =1; ind<n; ind++){
            for(int cap=0; cap<=W; cap++){

                int notTaken = dp[ind - 1][cap];

                int taken = Integer.MIN_VALUE;
                if(wt[ind] <= cap)
                    taken = val[ind] + dp[ind][cap - wt[ind]];

                dp[ind][cap] = Math.max(notTaken, taken);
            }
        }

        return dp[n-1][W];
    }
    static int unboundedKnapsack_sp_opt_01(int n, int W, int[] val,int[] wt) {

        int[] cur =new int[W+1];

        //Base Condition

        for(int i=wt[0]; i<=W; i++){
            cur[i] = ((int)i/wt[0]) * val[0];
        }

        for(int ind =1; ind<n; ind++){
            for(int cap=0; cap<=W; cap++){

                int notTaken = cur[cap];

                int taken = Integer.MIN_VALUE;
                if(wt[ind] <= cap)
                    taken = val[ind] + cur[cap - wt[ind]];

                cur[cap] = Math.max(notTaken, taken);
            }
        }

        return cur[W];

    }
}
