// GFG problem solution
// Leetcode link => https://leetcode.com/problems/number-of-islands/

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] vis = new boolean[row][col];
        int ans = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] != '0' && !vis[i][j]){
                    fun(grid, vis, i, j);
                    ans++;
                }
            }
        }

        return ans;
    }

    void fun(char[][] grid, boolean[][] vis, int i, int j){
        if(i<0 || i==grid.length || j<0 || j==grid[0].length || grid[i][j] == '0' || vis[i][j]) return;
        vis[i][j] = true;

        fun(grid, vis, i+1, j);
        fun(grid, vis, i+1, j+1);
        fun(grid, vis, i, j+1);
        fun(grid, vis, i-1, j+1);
        fun(grid, vis, i-1, j);
        fun(grid, vis, i-1, j-1);
        fun(grid, vis, i, j-1);
        fun(grid, vis, i+1, j-1);
    }
}
