// Leetcode link => https://leetcode.com/problems/dungeon-game/

class DungeonGame {
    public int calculateMinimumHP(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(i == m-1 && j == n-1){
                    dp[i][j] = grid[i][j] < 0 ? grid[i][j] : 0;
                }
                else if(i == m-1){
                    dp[i][j] = dp[i][j+1] + grid[i][j];
                    if(dp[i][j] > 0) dp[i][j] = 0;
                }
                else if(j == n-1){
                    dp[i][j] = dp[i+1][j] + grid[i][j];
                    if(dp[i][j] > 0) dp[i][j] = 0;
                }
                else{
                    dp[i][j] = grid[i][j] + Math.max(dp[i+1][j], dp[i][j+1]);
                    if(dp[i][j] > 0) dp[i][j] = 0;
                }
            }
        }

        return Math.abs(dp[0][0]) + 1;
    }
}
