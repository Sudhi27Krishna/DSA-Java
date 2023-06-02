class KnightProbabilityInChessboard {
    int[][] dir = {{1,2}, {1,-2}, {2,1}, {2,-1}, {-2,1}, {-2,-1}, {-1,2}, {-1,-2}};
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k+1][n][n];
        for(double[][] mat : dp){
            for(double[] arr : mat) Arrays.fill(arr, -1);
        }
        return solve(row, column, n, k, dp);
    }

    double solve(int r, int c, int n, int k, double[][][] dp){
        if(r < 0 || r >= n || c < 0 || c >= n) return 0;
        if(k == 0) return 1;
        if(dp[k][r][c] != -1) return dp[k][r][c];
        double res = 0;
        for(int i=0; i<8; i++){
            res += 0.125 * solve(r + dir[i][0], c + dir[i][1], n, k-1, dp);
        }
        return dp[k][r][c] = res;
    }
  
  // Tabulation
  class Solution {
    private int[][] dirs = new int[][]{{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
    public double knightProbability(int N, int K, int r, int c) {
        double[][][] dp = new double[K + 1][N][N];
        dp[0][r][c] = 1;
        for (int step = 1; step <= K; step++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int[] dir : dirs) {
                        int x = dir[0] + i;
                        int y = dir[1] + j;
                        if (x < 0 || x >= N || y < 0 || y >= N) continue;
                        dp[step][i][j] += dp[step - 1][x][y] * 0.125;
                    }
                }
            }
        }
        double res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res += dp[K][i][j];
            }
        }
        return res;
    }
  }
  
  // Space Optimization
  class Solution {
    private int[][] dirs = new int[][]{{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
    public double knightProbability(int N, int K, int r, int c) {
        double[][] prev = new double[N][N];
        prev[r][c] = 1;
        for (int step = 1; step <= K; step++) {
            double[][] curr = new double[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int[] dir : dirs) {
                        int x = dir[0] + i;
                        int y = dir[1] + j;
                        if (x < 0 || x >= N || y < 0 || y >= N) continue;
                        curr[i][j] += prev[x][y] * 0.125;
                    }
                }
            }
            prev = curr;
        }
        double res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res += prev[i][j];
            }
        }
        return res;
    }
  }
}
