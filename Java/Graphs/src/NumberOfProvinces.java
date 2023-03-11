// Leetcode link => https://leetcode.com/problems/number-of-provinces/description/

class  NumberOfProvinces {
    public int findCircleNum(int[][] matrix) {
        int n = matrix.length;
        boolean[] vis = new boolean[n];
        int ans = 0;
        for(int i=0; i<n; i++){
            if(!vis[i]){
                ans++;
                dfs(matrix, vis, i);
            }
        }
        return ans;
    }

    void dfs(int[][] matrix, boolean[] vis, int node){
        vis[node] = true;
        for(int i=0; i<matrix[node].length; i++){
            if(matrix[node][i] == 1 && !vis[i]){
                dfs(matrix, vis, i);
            }
        }
    }
}
