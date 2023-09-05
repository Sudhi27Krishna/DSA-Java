// Leetcode link => https://leetcode.com/problems/count-square-submatrices-with-all-ones/

class CountSquareSubmatrices {
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, sum = 0;
        int[][] dp = new int[m][n];

        for(int i=0; i<n; i++) dp[0][i] = matrix[0][i];
        for(int i=0; i<m; i++) dp[i][0] = matrix[i][0];

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][j] == 0) dp[i][j] = 0;
                else dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
            }
        }

        for(int[] row : dp) for(int num : row) sum += num;
        return sum;
    }
}
