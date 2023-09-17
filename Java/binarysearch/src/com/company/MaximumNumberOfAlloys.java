// Leetcode link => https://leetcode.com/problems/maximum-number-of-alloys/description/

class MaximumNumberOfAlloys {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        long low = 0, high = (long)(1e9);
        long ans = 0;
        while(low <= high){
            long mid = low + (high - low) / 2;
            if(isPossible(mid, budget, composition, stock, cost)){
                ans = mid;
                low = mid + 1;
            }
            else high = mid - 1;
        }

        return (int)ans;
    }

    boolean isPossible(long mid, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost){
        long minCost = Integer.MAX_VALUE;
        for(int i=0; i<composition.size(); i++){
            long machineCost = 0;
            for(int j=0; j<composition.get(i).size(); j++){
                long need = mid * composition.get(i).get(j);
                if(stock.get(j) >= need) continue;
                else{
                    long expense = (need - stock.get(j)) * cost.get(j);
                    machineCost += expense;
                }
            }
            
            minCost = Math.min(minCost, machineCost);
        }

        return minCost <= budget;
    }
}
