// GFG link => https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1#

class MColoringProblem {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(graph[i][j]){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        
        int[] color = new int[n+1];
        return fun(0, adj, color, m, n);
    }
    
    public boolean fun(int node, List<List<Integer>> adj, int[] color, int m, int n){
        if(node == n) return true;
        
        for(int i=1; i<=m; i++){
            if(isSafe(node, adj, i, color, m)){
                color[node] = i;
                if(fun(node+1, adj, color, m, n)) return true;
                color[node] = 0;
            }
        }
        
        return false;
    }
    
    public boolean isSafe(int node, List<List<Integer>> adj,int curr, int[] color, int m){
        for(int it : adj.get(node)){
            if(color[it] == curr) return false;
        }
        return true;
    }
}
