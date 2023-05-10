// Leetcode link => https://leetcode.com/problems/find-k-closest-elements/description/
// java pair class approach in solutions section

class FindKClosestElements {
    static class Pair{
        int u,v;
        public Pair(int u, int v){
            this.u = u;
            this.v = v;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2){
                if(p1.u == p2.u){
                    return p2.v-p1.v;
                }
                return p2.u - p1.u;
            }
        });

        for(int i=0; i<arr.length; i++){
            pq.offer(new Pair(Math.abs(arr[i]-x), arr[i]));
            if(pq.size() > k) pq.poll();
        }

        List<Integer> list = new ArrayList<Integer>();

        while(!pq.isEmpty()) list.add(pq.poll().v);

        Collections.sort(list);
        return list;
    }
}
