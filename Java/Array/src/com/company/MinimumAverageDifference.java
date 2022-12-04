// https://leetcode.com/problems/minimum-average-difference/

class MinimumAverageDifference {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n+1];
        long[] suffix = new long[n+1];
        int minAvg = Integer.MAX_VALUE;
        int ans = -1;
        
        for(int i=0; i<n; i++){
            prefix[i+1] = prefix[i] + nums[i];
        }
        
        for(int i=n-1; i>= 0; i--){
            suffix[i] = suffix[i+1] + nums[i];
        }
        
        for(int i=0; i<n; i++){
            long left = prefix[i+1] / (i+1);
            long right = 0;
            if(i != n-1){
                right = suffix[i+1] / (n-i-1);
            }
            int min = (int)Math.abs(right - left);
            
            if(min < minAvg){
                minAvg = min;
                ans = i;
            }
        }
        
        return ans;
    }
}
