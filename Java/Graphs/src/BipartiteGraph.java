// GFG link => https://practice.geeksforgeeks.org/problems/bipartite-graph/1

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if(color[i] == -1){
                if(!bfsCheck(adj, i, color)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean bfsCheck(ArrayList<ArrayList<Integer>> adj, int node, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
            Integer temp = q.poll();

            for(Integer it : adj.get(temp)){
                if(color[it] == -1){
                    color[it] = 1 - color[temp];
                    q.add(it);
                }
                else if (color[it] == color[temp]) return false;
            }
        }
        return true;
    }
}
