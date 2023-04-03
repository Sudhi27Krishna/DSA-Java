// (0/1) Knapsack problem - code studio

import java.util.Arrays;

public class KnapsackDP_0_1 {
    public static void main(String[] args) {
        int wt[] = {1,2,4,5};
        int val[] = {5,4,8,6};
        int W=5;

        int n = wt.length;

        System.out.println("The Maximum value of items, thief can steal is "+
                knapsack(wt,val,n,W));
    }

    // Memoization
    static int knapsack(int[] wt,int[] val, int n, int W){

        int dp[][]= new int[n][W+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);
        return knapsackUtil(wt, val, n-1, W, dp);
    }

    static int knapsackUtil(int[] wt,int[] val, int ind, int W,int[][] dp){

        if(ind == 0){
            if(wt[0] <=W) return val[0];
            else return 0;
        }

        if(dp[ind][W]!=-1)
            return dp[ind][W];

        int notTaken = knapsackUtil(wt, val, ind - 1, W, dp);

        int taken = Integer.MIN_VALUE;
        if(wt[ind] <= W)
            taken = val[ind] + knapsackUtil(wt,val,ind-1,W-wt[ind],dp);

        return dp[ind][W] = Math.max(notTaken,taken);
    }

    static int knapsack_tablulation(int[] wt,int[] val, int n, int W){

        int dp[][] = new int[n][W+1];

        //Base Condition

        for(int i=wt[0]; i<=W; i++){
            dp[0][i] = val[0];
        }

        for(int ind =1; ind<n; ind++){
            for(int cap=0; cap<=W; cap++){

                int notTaken = dp[ind - 1][cap];

                int taken = Integer.MIN_VALUE;
                if(wt[ind] <= cap)
                    taken = val[ind] + dp[ind-1][cap - wt[ind]];

                dp[ind][cap] = Math.max(notTaken, taken);
            }
        }

        return dp[n-1][W];
    }

    static int knapsack_sp_opt(int[] wt, int[] val, int n, int W) {
        int[] prev = new int[W+1];
        //Base Condition

        for(int i=wt[0]; i<=W; i++){
            prev[i] = val[0];
        }

        for(int ind =1; ind<n; ind++){
            int[] curr = new int[W+1];
            for(int cap=0; cap<=W; cap++){

                int notTaken = prev[cap];

                int taken = Integer.MIN_VALUE;
                if(wt[ind] <= cap)
                    taken = val[ind] + prev[cap - wt[ind]];

                curr[cap] = Math.max(notTaken, taken);
            }
            prev = curr;
        }

        return prev[W];
    }

    static int knapsack_sp_opt_01(int[] wt, int[] val, int n, int W) {
        int[] prev = new int[W+1];
        //Base Condition

        for(int i=wt[0]; i<=W; i++){
            prev[i] = val[0];
        }

        for(int ind =1; ind<n; ind++){
            for(int cap=W; cap>=0; cap--){

                int notTaken = prev[cap];

                int taken = Integer.MIN_VALUE;
                if(wt[ind] <= cap)
                    taken = val[ind] + prev[cap - wt[ind]];

                prev[cap] = Math.max(notTaken, taken);
            }
        }

        return prev[W];
    }
}
