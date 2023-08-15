// Leetcode link => https://leetcode.com/problems/partition-array-for-maximum-sum/description/

class Partition_Array_for_Maximum_Sum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return fun(0, arr, k, dp);
    }

    int fun(int ind, int[] arr, int k, int[] dp){
        if(ind == arr.length) return 0;

        if(dp[ind] != -1) return dp[ind];

        int max = Integer.MIN_VALUE, res = Integer.MIN_VALUE, len = 0;
        for(int i=ind; i<Math.min(arr.length, ind+k); i++){
            len++;
            max = Math.max(max, arr[i]);
            int sum = max*len + fun(i+1, arr, k, dp);
            res = Math.max(res, sum);
        }

        return dp[ind] = res;
    }

  // Tabulation
  public int maxSumAfterPartitioning_tab(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n+1];
        dp[n] = 0;
        for(int i=n-1; i>=0; i--){
            int max = Integer.MIN_VALUE, res = Integer.MIN_VALUE, len = 0;
            for(int j=i; j<Math.min(arr.length, i+k); j++){
                len++;
                max = Math.max(max, arr[j]);
                int sum = max*len + fun(j+1, arr, k, dp);
                res = Math.max(res, sum);
            }
            dp[i] = res;
        }
        return dp[0];
    }
}
