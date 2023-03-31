// GFG link => https://practice.geeksforgeeks.org/problems/number-of-distinct-islands/1

import java.util.ArrayList;
import java.util.HashSet;
public class NoOfDistinctIslands {
    int countDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        HashSet<ArrayList<String>> st = new HashSet<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    ArrayList<String> list = new ArrayList<>();
                    dfs(i, j, grid, vis, list, i, j);
                    st.add(list);
                }
            }
        }

        return st.size();
    }

    private String toString(int r, int c) {
        return Integer.toString(r) + " " + Integer.toString(c);
    }

    void dfs(int i, int j, int[][] grid, boolean[][] vis, ArrayList<String> list, int i_row, int i_col){
        int m = grid.length;
        int n = grid[0].length;

        if(i<0||j<0||i==m||j==n||grid[i][j]==0||vis[i][j]) return;

        vis[i][j] = true;
        list.add(toString(i-i_row, j-i_col));

        int[] dRow = {1, 0, -1, 0};
        int[] dCol = {0, 1, 0, -1};

        for(int k=0; k<dRow.length; k++){
            int fRow = i + dRow[k];
            int fCol = j + dCol[k];
            dfs(fRow, fCol, grid, vis, list, i_row, i_col);
        }
    }
}
