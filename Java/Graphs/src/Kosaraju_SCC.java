import java.util.ArrayList;
import java.util.Stack;

public class Kosaraju_SCC {
    Stack<Integer> st = new Stack<>();
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] vis = new boolean[V];

        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfs(i, vis, adj);
            }
        }

        // Reversing the graph
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjT.add(new ArrayList<Integer>());
        }
        for(int i=0; i<V; i++){
            vis[i] = false;
            for(int it : adj.get(i)){
                // i -> it
                // after reversing it -> i
                adjT.get(it).add(i);
            }
        }

        int scc_cnt = 0;
        while(!st.isEmpty()){
            int node = st.pop();
            if(!vis[node]){
                scc_cnt++;
                dfs(node,vis,adjT);
            }
        }

        return scc_cnt;
    }

    void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        for(int it : adj.get(node)){
            if(!vis[it]){
                dfs(it, vis, adj);
            }
        }
        st.push(node);
    }
}
