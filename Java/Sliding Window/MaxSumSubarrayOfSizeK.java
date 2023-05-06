// GFG link => https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1

class MaxSumSubarrayOfSizeK{
    static long maximumSumSubarray(int k, ArrayList<Integer> Arr,int N){
        int i = 0, j = 0;
        long sum = 0;
        long max = 0;
        
        while(j < N){
            sum += Arr.get(j);
            if(j-i+1 < k){
                j++;
            }
            else{
                max = Math.max(max, sum);
                sum -= Arr.get(i);
                i++; j++;
            }
        }
        
        return max;
    }
}