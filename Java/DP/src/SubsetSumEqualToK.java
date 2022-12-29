// Code Studio

import java.util.Arrays;

public class SubsetSumEqualToK {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        int[][] dp = new int[n][k+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return fun_memoize(n-1,k,arr,dp);
//        return fun(n-1,k,arr);
    }

    public static boolean fun(int i, int target, int[] arr){
        if(target == 0) return true;
        if(i == 0) return (arr[0] == target);

        boolean notTake = fun(i-1,target,arr);
        boolean take = false;
        if(target >= arr[i]){
            take = fun(i-1, target-arr[i],arr);
        }

        return (take || notTake);
    }

    public static boolean fun_memoize(int i, int target, int[] arr, int[][] dp){
        if(target == 0) return true;
        if(i == 0) return (arr[0] == target);

        if(dp[i][target] != -1) return (dp[i][target] == 1);

        boolean notTake = fun_memoize(i-1,target,arr,dp);
        boolean take = false;
        if(target >= arr[i]){
            take = fun_memoize(i-1, target-arr[i],arr,dp);
        }

        dp[i][target] = (take || notTake) ? 1 : 0;
        return (take || notTake);
    }

    public static boolean subsetSumToK_tabulation(int n, int k, int[] arr){
        boolean[][] dp = new boolean[n][k+1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if(arr[0] <= k){
            dp[0][arr[0]] = true;
        }

        for(int ind=1; ind<n; ind++){
            for(int tar=1; tar<=k; tar++){
                boolean notTake = dp[ind-1][tar];
                boolean take = false;
                if(arr[ind] <= tar){
                    take = dp[ind-1][tar-arr[ind]];
                }
                dp[ind][tar] = (take || notTake);
            }
        }

        return dp[n-1][k];
    }

    public static boolean subsetSumToK_sp_opt(int n, int k, int[] arr){
        boolean[] prev = new boolean[k+1];
        prev[0] = true;

        if(arr[0] <= k){
            prev[arr[0]] = true;
        }

        for(int ind=1; ind<n; ind++){
            boolean[] curr = new boolean[k+1];
            curr[0] = true;
            for(int tar=1; tar<=k; tar++){
                boolean notTake = prev[tar];
                boolean take = false;
                if(arr[ind] <= tar){
                    take = prev[tar-arr[ind]];
                }
                curr[tar] = (take || notTake);
            }
            prev = curr;
        }

        return prev[k];
    }
}
