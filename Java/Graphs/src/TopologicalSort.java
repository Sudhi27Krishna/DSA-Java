// GFG link => https://practice.geeksforgeeks.org/problems/topological-sort/1

class TopologicalSort
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] ans = new int[V];
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfs(i, vis, adj, st);
            }
        }
        
        int ind = 0;
        while(!st.isEmpty()){
            ans[ind++] = st.pop();
        }
        
        return ans;
    }
    
    static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        vis[node] = true;
        for(int it : adj.get(node)){
            if(!vis[it]){
                dfs(it, vis, adj, st);
            }
        }
        st.push(node);
    }
}
