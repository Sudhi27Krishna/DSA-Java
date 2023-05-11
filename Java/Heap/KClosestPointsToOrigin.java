// Leetcode link => https://leetcode.com/problems/k-closest-points-to-origin/description/

class KClosestPointsToOrigin {
    class Pair{
        int x;
        int y;
        int dist;

        Pair(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(
            (x, y) -> y.dist - x.dist
        );

        int[][] ans = new int[k][2];
        int ind = 0;

        for(int i=0; i<points.length; i++){
            int dist = (int)Math.pow(points[i][0]-0, 2) + (int)Math.pow(points[i][1]-0, 2);
            pq.offer(new Pair(points[i][0], points[i][1], dist));
            if(pq.size() > k) pq.poll();
        }

        while(!pq.isEmpty()){
            Pair temp = pq.poll();
            ans[ind][0] = temp.x;
            ans[ind][1] = temp.y;
            ind++;
        }

        return ans;
    }
}
