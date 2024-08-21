// Leetcode link => https://leetcode.com/problems/remove-boxes/

class RemoveBoxes {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        for(int[][] mat : dp) for(int[] row : mat) Arrays.fill(row, -1);
        return fun(0, n-1, 0, boxes, dp);
    }

    private int fun(int i, int j, int k, int[] boxes, int[][][] dp){
        if(i > j) return 0;

        int I = i, K = k;
        if(dp[I][j][K] != -1) return dp[I][j][K];

        for(; i+1<=j && boxes[i] == boxes[i+1]; i++, k++);
        int res = (k+1)*(k+1) + fun(i+1, j, 0, boxes, dp);

        for(int m=i+1; m<=j; m++){
            if(boxes[i] == boxes[m]){
                res = Math.max(res, fun(i+1, m-1, 0, boxes, dp) + fun(m, j, k+1, boxes, dp));
            }
        }

        return dp[I][j][K] = res;
    }
}
