// Leetcode link => https://leetcode.com/problems/largest-divisible-subset/description/

class Largest_Divisible_Subset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] hash = new int[n];
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i=0; i<n; i++){
            hash[i] = i;
            for(int prev_ind=0; prev_ind<i; prev_ind++){
                if(nums[i]%nums[prev_ind] == 0 && dp[i] < dp[prev_ind] + 1){
                    dp[i] = 1 + dp[prev_ind];
                    hash[i] = prev_ind;
                }
            }
        }

        int max = 0;
        int last_ind = 0;

        for(int i=0; i<n; i++){
            if(dp[i] > max){
                max = dp[i];
                last_ind = i;
            }
        }

        List<Integer> res = new ArrayList<>();
        res.add(nums[last_ind]);

        while(hash[last_ind] != last_ind){
            last_ind = hash[last_ind];
            res.add(nums[last_ind]);
        }

        return res;
    }
}
