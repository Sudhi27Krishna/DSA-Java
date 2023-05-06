// GFG link => https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
class FirstNegativeIntegerInWindowSizeK {
    public long[] printFirstNegativeInteger(long A[], int N, int k)
    {
        int ans_size = N - k + 1;
        long[] ans = new long[ans_size];
        int i = 0, j = 0, ind = 0;
        
        Queue<Long> q = new LinkedList<>();
        
        while(j < N){
            if(A[j] < 0) q.offer(A[j]);
            if(j - i + 1 < k){
                j++;
            }
            else{
                ans[ind++] = (!q.isEmpty()) ? q.peek() : 0;
                j++;
                if(!q.isEmpty() && A[i] == q.peek()) q.poll();
                i++;
            }
        }
        
        return ans;
    }
}