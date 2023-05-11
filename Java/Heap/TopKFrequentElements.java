// Leetcode link => https://leetcode.com/problems/top-k-frequent-elements/description/

class TopKFrequentElements {
    class Pair{
        int freq;
        int elm;

        Pair(int freq, int elm){
            this.freq = freq;
            this.elm = elm;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        int ind = 0;
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (x, y) -> (x.freq == y.freq) ? x.elm - y.elm :  x.freq - y.freq
        );

        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(Integer key : map.keySet()){
            pq.offer(new Pair(map.get(key), key));
            if(pq.size() > k) pq.poll();
        }

        while(!pq.isEmpty()) ans[ind++] = pq.poll().elm;

        return ans;
    }
}
