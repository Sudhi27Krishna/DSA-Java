// link => https://leetcode.com/problems/partition-equal-subset-sum/description/

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int target = 0;
        for(int elm : nums){
            target += elm;
        }

        if(target%2 != 0) return false;

        return subsetSumToK_sp_opt(nums.length,target/2,nums);
    }

    public boolean subsetSumToK_sp_opt(int n, int k, int[] arr){
        boolean[] prev = new boolean[k+1];
        prev[0] = true;

        if(arr[0] <= k){
            prev[arr[0]] = true;
        }

        for(int ind=1; ind<n; ind++){
            boolean[] curr = new boolean[k+1];
            curr[0] = true;
            for(int tar=1; tar<=k; tar++){
                boolean notTake = prev[tar];
                boolean take = false;
                if(arr[ind] <= tar){
                    take = prev[tar-arr[ind]];
                }
                curr[tar] = (take || notTake);
            }
            prev = curr;
        }

        return prev[k];
    }
}
