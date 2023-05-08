// Leetcode link => https://leetcode.com/problems/sliding-window-maximum/description/
// GFG link => https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1

class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int[] ans = new int[n-k+1];

        Deque<Integer> dq = new ArrayDeque<>();

        int i = 0, j = 0, ind = 0;

        while(j < n){
            if(dq.size() == 0){
                dq.offerLast(arr[j]);
            }
            else{
                while(dq.size() > 0 && dq.peekLast() < arr[j]) dq.pollLast();
                dq.offerLast(arr[j]);
            }

            if(j - i + 1 < k){
                j++;
            }
            else if(j - i + 1 == k){
                ans[ind++] = dq.peekFirst();
                if(dq.peekFirst() == arr[i]) dq.pollFirst();
                i++; j++;
            }
        }

        return ans;
    }
}
