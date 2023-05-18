// Leetcode link => https://leetcode.com/problems/next-greater-element-ii/description/

class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] nge = new int[n];

        for(int i=2*n-1; i>=0; i--){
            while(!st.isEmpty() && st.peek() <= nums[i%n]) st.pop();

            nge[i%n] = st.isEmpty() ? -1 : st.peek();

            st.push(nums[i%n]);
        }

        return nge;
    }
}
