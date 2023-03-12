// Leetcode link => https://leetcode.com/problems/rotting-oranges/

import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int row;
    int col;
    int time;
    Pair(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int cntFresh = 0;
        int[][] vis = new int[r][c];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j] == 2){
                    q.offer(new Pair(i, j, 0));
                    vis[i][j] = 2;
                }
                else {
                    vis[i][j] = 0;
                }
                if (grid[i][j] == 1) cntFresh++;
            }
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        int cnt = 0;
        int time = 0;
        while(!q.isEmpty()){
            Pair node = q.poll();
            int row = node.row;
            int col = node.col;
            time = Math.max(time, node.time);

            for(int i=0; i<4; i++){
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];
                if(nRow >=0 && nRow < r && nCol >=0 && nCol < c && vis[nRow][nCol] == 0 && grid[nRow][nCol] == 1){
                    q.offer(new Pair(nRow, nCol, time+1));
                    vis[nRow][nCol] = 2;
                    cnt++;
                }
            }
        }

        if (cnt != cntFresh) return -1;
        return time;
    }
}