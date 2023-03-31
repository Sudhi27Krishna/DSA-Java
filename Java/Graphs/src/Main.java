import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int first;
    int second;

    public Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class Main {
    public static void main(String[] args) {

    }
    // BFS Cycle Detection
    public static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int s, boolean[] vis) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(s,-1));
        vis[s] = true;

        while(!queue.isEmpty()){
            int node = queue.peek().first;
            int parent = queue.peek().second;

            for(Integer it : adj.get(node)){
                if(!vis[it]){
                    vis[it] = true;
                    queue.add(new Node(it, node));
                } else if (it != parent) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[V+1];
        Arrays.fill(vis, false);

        for (int i = 1; i <= V; i++) {
            if(!vis[i]){
                if(checkForCycle(adj, i, vis)){
                    return true;
                }
            }
        }

        return false;
    }

    // DFS Cycle Detection
    public static boolean dfsCycle(ArrayList<ArrayList<Integer>> adj, int node, int par, boolean[] vis){
        vis[node] = true;
        for (int it : adj.get(node)){
            if(!vis[it]){
                if (dfsCycle(adj, it, node, vis)){
                    return true;
                }
            } else if (it != par) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCycleDFS(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[V+1];
        Arrays.fill(vis, false);

        for (int i = 1; i <= V; i++) {
            if(!vis[i]){
                if(dfsCycle(adj, i, -1, vis)){
                    return true;
                }
            }
        }

        return false;
    }
}
