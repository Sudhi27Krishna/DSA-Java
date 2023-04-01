// GFG link => https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
// Leetcode link => https://leetcode.com/problems/course-schedule/

import java.util.ArrayList;

public class DirectedCycleDetectionDFS {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];

        for(int i=0; i<V; i++){
            if(!vis[i]){
                if(dfs(i, adj, vis, pathVis)) return true;
            }
        }

        return false;
    }

    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] pathVis){
        vis[node] = true;
        pathVis[node] = true;

        for(int it : adj.get(node)){
            if(!vis[it]){
                if(dfs(it, adj, vis, pathVis)) return true;
            }
            else if(pathVis[it]) return true;
        }

        pathVis[node] = false;
        return false;
    }
}
