// Leetcode link => https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation/

class MaximumBeautyOfAnArrayAfterApplyingOperation {
    public int maximumBeauty(int[] nums, int k) {
        int offset = 100000;
        int n = nums.length;
        int[] freq = new int[300002];
        
        for(int i=0; i<n; i++){
            int start = nums[i] - k;
            int end = nums[i] + k;
            
            freq[start+offset]++;
            freq[end+offset+1]--;
        }
        int ans = freq[0];
        for(int i=1; i<freq.length; i++){
            freq[i] += freq[i-1];
            ans = Math.max(ans, freq[i]);
        }
        return ans;
    }
}
