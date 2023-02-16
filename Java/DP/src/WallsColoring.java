
// GFG => https://practice.geeksforgeeks.org/problems/51b266505221b97522b1d2c86ddad1868a54831b/0

class WallsColoring{
	int minCost(int [][] colors, int N){
	    int[][] dp = new int[colors.length][3];
	    for(int[] row : dp){
	        Arrays.fill(row, -1);
	    }
        int min = Integer.MAX_VALUE;
        for(int j=0; j <=2; j++){
            min = Math.min(min, fun(0,j,colors, j, dp));
        }
        
        return min;
    }
    
    int fun(int i, int j, int[][] colors, int prev_j, int[][] dp){
        if(i == colors.length-1){
            return colors[i][j];
        }
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int min = Integer.MAX_VALUE;
        for(int k=0; k <=2; k++){
            if(prev_j != k){
                min = Math.min(min, fun(i+1, k, colors, k, dp) + colors[i][j]);
            }
        }
        
        return dp[i][j] = min;
    }
  
    int minCost_tabulation(int [][] colors, int N){
	    int[][] dp = new int[colors.length][3];
	    for(int i=0; i<=2; i++){
	        dp[colors.length-1][i] = colors[colors.length-1][i];
	    }
	    
	    for(int i=colors.length-2; i>= 0; i--){
	        for(int last = 0; last <=2; last++){
	            int price = Integer.MAX_VALUE;
	            for(int j=0; j<=2; j++){
	                if(last != j){
	                    price = Math.min(price, dp[i+1][j]);
	                }
	            }
	            dp[i][last] = price + colors[i][last];
	        }
	    }
	    
	    int min = Integer.MAX_VALUE;
	    for(int i=0; i<=2; i++){
	        min = Math.min(min, dp[0][i]);
	    }
	    
	    return min;
    }
    
    int minCost_sp_opt(int [][] colors, int N){
	    int[] prev = new int[3];
	    for(int i=0; i<=2; i++){
	        prev[i] = colors[colors.length-1][i];
	    }
	    
	    for(int i=colors.length-2; i>= 0; i--){
	        int[] curr = new int[3];
	        for(int last = 0; last <=2; last++){
	            int price = Integer.MAX_VALUE;
	            for(int j=0; j<=2; j++){
	                if(last != j){
	                    price = Math.min(price, prev[j]);
	                }
	            }
	            curr[last] = price + colors[i][last];
	        }
	        prev = curr;
	    }
	    
	    int min = Integer.MAX_VALUE;
	    for(int i=0; i<=2; i++){
	        min = Math.min(min, prev[i]);
	    }
	    
	    return min;
    }
}
