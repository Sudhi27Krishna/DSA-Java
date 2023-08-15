// Leetcode link => https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/

class MinimumCostToCutAStick {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int len = cuts.length;
        int[] arr = new int[len+2];
        arr[0] = 0;
        arr[len+1] = n;
        for(int i=1; i<=len; i++){
            arr[i] = cuts[i-1];
        }
        return fun(1, len, arr);
    }

    int fun(int i, int j, int[] cuts){
        if(i > j) return 0;

        int min = (int)(1e9);
        for(int ind=i; ind<=j; ind++){
            int cost = cuts[j+1] - cuts[i-1] + fun(i, ind-1, cuts) + fun(ind+1, j, cuts);
            min = Math.min(min, cost);
        }

        return min;
    }

  // Memoization
  public int minCost_memo(int n, int[] cuts) {
        Arrays.sort(cuts);
        int len = cuts.length;
        int[] arr = new int[len+2];
        arr[0] = 0;
        arr[len+1] = n;
        for(int i=1; i<=len; i++){
            arr[i] = cuts[i-1];
        }
        int[][] dp = new int[arr.length+1][arr.length+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return fun(1, len, arr, dp);
    }

    int fun_memo(int i, int j, int[] cuts, int[][] dp){
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int min = (int)(1e9);
        for(int ind=i; ind<=j; ind++){
            int cost = cuts[j+1]-cuts[i-1]+fun_memo(i, ind-1, cuts, dp)+fun_memo(ind+1, j, cuts, dp);
            min = Math.min(min, cost);
        }

        return dp[i][j] = min;
    }

  // Tabulation
  public int minCost_tab(int n, int[] cuts) {
        Arrays.sort(cuts);
        int len = cuts.length;
        int[] arr = new int[len+2];
        arr[0] = 0;
        arr[len+1] = n;
        for(int i=1; i<=len; i++){
            arr[i] = cuts[i-1];
        }
        int[][] dp = new int[len+2][len+2];
        for(int i=len; i>=1; i--){
            for(int j=1; j<=len; j++){
                if(i > j) continue;
                int min = Integer.MAX_VALUE;
                for(int ind=i; ind<=j; ind++){
                    int cost = arr[j+1] - arr[i-1] + dp[i][ind-1] + dp[ind+1][j];
                    min = Math.min(min, cost);
                }
                dp[i][j] = min;
            }
        }

        return dp[1][len];
    }
}
