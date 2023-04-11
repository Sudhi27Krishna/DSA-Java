import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Link {
    int node;
    int distance;
    public Link(int distance, int node){
        this.node = node;
        this.distance = distance;
    }
}
public class DijkstraPQ {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Create a priority queue for storing the nodes as a pair {dist, node
        // where dist is the distance from source to the node.
//        PriorityQueue<LInk> pq = new PriorityQueue<LInk>((x, y) -> x.distance - y.distance);
        PriorityQueue<Link> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));

        int[] dist = new int[V];

        // Initialising distTo list with a large number to
        // indicate the nodes are unvisited initially.
        // This list contains distance from source to the nodes.
        Arrays.fill(dist, (int) (1e9));

        // Source initialised with dist=0.
        dist[S] = 0;
        pq.add(new Link(0,S));

        // Now, pop the minimum distance node first from the min-heap
        // and traverse for all its adjacent nodes.
        while(pq.size() != 0) {
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            // Check for all adjacent nodes of the popped out
            // element whether the prev dist is larger than current or not.
            for(int i = 0;i<adj.get(node).size();i++) {
                int edgeWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);

                // If current distance is smaller,
                // push it into the queue.
                if(dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Link(dist[adjNode], adjNode));
                }
            }
        }
        // Return the list containing the shortest distances
        // from source to all the nodes.
        return dist;
    }
}
