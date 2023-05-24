// Leetcode link => https://leetcode.com/problems/maximum-product-subarray/description/

class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] dpMax = new int[n];
        int[] dpMin = new int[n];

        dpMax[0] = nums[0];
        dpMin[0] = nums[0];

        for(int i=1; i<n; i++){
            if(nums[i] < 0){
                dpMax[i] = Math.max(nums[i], nums[i] * dpMin[i-1]);
                dpMin[i] = Math.min(nums[i], nums[i] * dpMax[i-1]);
            }
            else{
                dpMax[i] = Math.max(nums[i], nums[i] * dpMax[i-1]);
                dpMin[i] = Math.min(nums[i], nums[i] * dpMin[i-1]);
            }
        }

        int res = Integer.MIN_VALUE;
        for(int num : dpMax) res = Math.max(res, num);

        return res;
    }
}
