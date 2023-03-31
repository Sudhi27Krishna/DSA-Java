// Leetcode link => https://leetcode.com/problems/01-matrix/description

import java.util.LinkedList;
import java.util.Queue;

public class Matrix_01 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] vis = new boolean[m][n];
        int[][] dist = new int[m][n];

        Queue<Triplet> q = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    q.offer(new Triplet(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }

        int[] del_row = {1, 0, -1, 0};
        int[] del_col = {0, 1, 0, -1};

        while(!q.isEmpty()){
            Triplet node = q.poll();
            int row = node.row;
            int col = node.col;
            int step = node.step;
            dist[row][col] = step;

            for(int i=0; i<4; i++){
                int dRow = row + del_row[i];
                int dCol = col + del_col[i];
                if(dRow >= 0 && dRow < m && dCol >= 0 && dCol < n && !vis[dRow][dCol]){
                    q.offer(new Triplet(dRow, dCol, step + 1));
                    vis[dRow][dCol] = true;
                }
            }
        }

        return dist;
    }
}

class Triplet {
    int row;
    int col;
    int step;
    Triplet(int row, int col, int step){
        this.row = row;
        this.col = col;
        this.step = step;
    }
}
