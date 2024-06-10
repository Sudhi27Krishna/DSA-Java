// Leetcode => https://leetcode.com/problems/subarray-sums-divisible-by-k/description/

class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, cnt = 0;
        
        for(int num : nums){
            sum += num;

            int rem = sum % k;
            if(rem < 0) rem += k;
            if(rem == 0) cnt++;

            if(map.containsKey(rem)) cnt += map.get(rem);

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return cnt;
    }
}
