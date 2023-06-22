// Leetcode => https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

class Best_Time_To_Buy_and_Sell_Stock_II
 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row : dp) Arrays.fill(row, -1);
        int ans = fun(0, prices, 1, dp);
        return ans < 0 ? 0 : ans;
    }
   
    int fun(int ind, int[] prices, int buy){
        if(ind == prices.length) return 0;

        int profit = Integer.MIN_VALUE;
        if(buy == 1){
            profit = Math.max(-prices[ind]+fun(ind+1, prices, 0), fun(ind+1, prices, 1));
        }
        else{
            profit = Math.max(prices[ind]+fun(ind+1, prices, 1), fun(ind+1, prices, 0));
        }

        return profit;
    }
  // Memoization
    int fun(int ind, int[] prices, int buy, int[][] dp){
        if(ind == prices.length) return 0;

        if(dp[ind][buy] != -1) return dp[ind][buy];

        int profit = Integer.MIN_VALUE;
        if(buy == 1){
            profit = Math.max(-prices[ind]+fun(ind+1, prices, 0, dp), fun(ind+1, prices, 1, dp));
        }
        else{
            profit = Math.max(prices[ind]+fun(ind+1, prices, 1, dp), fun(ind+1, prices, 0, dp));
        }

        return dp[ind][buy] = profit;
    }
   
   // Tabulation
   public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        dp[n][0] = dp[n][1] = 0;

        for(int i=n-1; i>=0; i--){
            for(int j=0; j<2; j++){
                int profit = Integer.MIN_VALUE;
                if(j == 1){
                    profit = Math.max(-prices[i]+dp[i+1][0], dp[i+1][1]);
                }
                else{
                    profit = Math.max(prices[i]+dp[i+1][1], dp[i+1][0]);
                }
                dp[i][j] = profit;
            }
        }

        int ans = dp[0][1];
        return ans < 0 ? 0 : ans;
    }

   // Space optimization
   public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] prev = new int[2];
        prev[0] = prev[1] = 0;

        for(int i=n-1; i>=0; i--){
            int[] curr = new int[2];
            for(int j=0; j<2; j++){
                int profit = Integer.MIN_VALUE;
                if(j == 1){
                    profit = Math.max(-prices[i]+prev[0], prev[1]);
                }
                else{
                    profit = Math.max(prices[i]+prev[1], prev[0]);
                }
                curr[j] = profit;
            }
            prev = curr;
        }

        int ans = prev[1];
        return ans < 0 ? 0 : ans;
    }
}
