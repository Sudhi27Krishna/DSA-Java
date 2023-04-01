// GFG link => https://practice.geeksforgeeks.org/problems/eventual-safe-states/1
// Leetcode link => https://leetcode.com/problems/find-eventual-safe-states/description/

import java.util.*;

public class EventualSafeNodes {
    class Solution {

        List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
            boolean[] vis = new boolean[V];
            boolean[] pathVis = new boolean[V];
            boolean[] check = new boolean[V];

            for(int i=0; i<V; i++){
                if(!vis[i]){
                    dfs(i, adj, vis, pathVis, check);
                }
            }

            List<Integer> safeNodes = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                if (check[i])
                    safeNodes.add(i);
            }
            return safeNodes;
        }

        public boolean dfs(int node, List<List<Integer>> adj, boolean[] vis,
                           boolean[] pathVis, boolean[] check){
            vis[node] = true;
            pathVis[node] = true;
            check[node] = false;

            for(int it : adj.get(node)){
                if(!vis[it]){
                    if(dfs(it, adj, vis, pathVis, check)){
                        check[node] = false;
                        return true;
                    }
                }
                else if(pathVis[it]){
                    check[node] = false;
                    return true;
                }
            }

            check[node] = true;
            pathVis[node] = false;
            return false;
        }
    }

    // BFS, Kahn's topological approach
    List<Integer> eventualSafeNodesBFS(int V, List<List<Integer>> adj) {
        List<List<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjRev.add(new ArrayList<>());
        }
        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            // i -> it
            // it -> i
            for (int it : adj.get(i)) {
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            safeNodes.add(node);
            for (int it : adjRev.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
}
