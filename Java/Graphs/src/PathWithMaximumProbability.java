// Leetcode link => https://leetcode.com/problems/path-with-maximum-probability/description/

class State {
	int node;
	double prob;
	State(int _node, double _prob) {
		node = _node;
		prob = _prob;
	}
}

class PathWithMaximumProbability {
//  Dijkstra Algorithm
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<double[]>> map = new HashMap<>();
        for (int i = 0; i < edges.length; ++i) {
            int[] edge = edges[i];

            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());

            map.get(edge[0]).add(new double[] {edge[1], succProb[i]});
            map.get(edge[1]).add(new double[] {edge[0], succProb[i]});
        }

        double[] probs = new double[n];  // best prob so far for each node
        PriorityQueue<State> pq = new PriorityQueue<>(
            (a, b) -> (((Double) b.prob).compareTo((Double) a.prob))
        );
        pq.offer(new State(start, 1.0));

        while(!pq.isEmpty()){
            State curr = pq.poll();
            int vertex = curr.node;
            double prob = curr.prob;

            if(vertex == end) return prob;

            for(double[] neighbor : map.getOrDefault(vertex, new ArrayList<>())){
                if(probs[(int) neighbor[0]] >= prob * neighbor[1]) continue;

                pq.offer(new State((int) neighbor[0], prob * neighbor[1]));
                probs[(int) neighbor[0]] = prob * neighbor[1];
            }
        }

        return 0;
    }

  // Floyd–Warshall Algorithm for Every Pair of Nodes
  public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[][] probs = new double[n][n];

        for (int i = 0; i < succProb.length; ++i) {
            int a = edges[i][0];
            int b = edges[i][1];
            probs[a][b] = probs[b][a] = succProb[i];
        }

        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    probs[i][j] = Math.max(probs[i][j], probs[i][k] * probs[k][j]);
                }
            }
        }

        return probs[start][end];
    }

  // Bellman - Ford Algorithm
  public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // build graph -> double[0]: node, double[1]: edge prob
        Map<Integer, List<double[]>> map = new HashMap<>();
        for (int i = 0; i < edges.length; ++i) {
            int[] edge = edges[i];

            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());

            map.get(edge[0]).add(new double[] {edge[1], succProb[i]});
            map.get(edge[1]).add(new double[] {edge[0], succProb[i]});
        }

        double[] probs = new double[n];  // best prob so far for each node
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(start, 1.0));

        while (!queue.isEmpty()) {

            State state = queue.poll();
            int parent = state.node;
            double prob = state.prob;

            for (double[] child : map.getOrDefault(parent, new ArrayList<>())) {
                // add to queue only if: it can make a better prob
                if (probs[(int) child[0]] >= prob * child[1]) continue;

                queue.add(new State((int) child[0], prob * child[1]));
                probs[(int) child[0]] = prob * child[1];
            }

        }

        return probs[end];
    }
}
