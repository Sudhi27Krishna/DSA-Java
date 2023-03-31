// Leetcode link => https://leetcode.com/problems/surrounded-regions/description

public class SurroundedRegions {
    public void solve(char[][] a) {
        int n = a.length;
        int m = a[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i=0; i<m; i++){
            if(a[0][i] == 'O' && !vis[0][i]) dfs(0, i, a, vis, n, m);
            if(a[n-1][i] == 'O' && !vis[n-1][i]) dfs(n-1, i, a, vis, n, m);
        }

        for(int i=0; i<n; i++){
            if(a[i][0] == 'O' && !vis[i][0]) dfs(i, 0, a, vis, n, m);
            if(a[i][m-1] == 'O' && !vis[i][m-1]) dfs(i, m-1, a, vis, n, m);
        }

        for(int i = 0; i<n; i++) {
            for(int j= 0; j<m; j++) {
                if(!vis[i][j] && a[i][j] == 'O')
                    a[i][j] = 'X';
            }
        }
    }

    void dfs(int i, int j, char a[][], boolean[][] vis, int n, int m){
        if(i < 0 || j < 0 || i == n || j == m || a[i][j] == 'X' || vis[i][j]) return;

        vis[i][j] = true;

        int[] dRow = {1, 0, -1, 0};
        int[] dCol = {0, 1, 0, -1};

        for(int k=0; k<dRow.length; k++){
            int fRow = i + dRow[k];
            int fCol = j + dCol[k];
            dfs(fRow, fCol, a, vis, n, m);
        }
    }
}
