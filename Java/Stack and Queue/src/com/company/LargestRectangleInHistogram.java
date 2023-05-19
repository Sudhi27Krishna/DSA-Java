// Leetcode link => https://leetcode.com/problems/largest-rectangle-in-histogram/description/

class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st= new Stack<>();
        int n = heights.length;
        int[] right = new int[n];
        int[] left = new int[n];
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();
            left[i] = st.isEmpty() ? 0 : st.peek() + 1;
            st.push(i);
        }

        st.clear();
        int maxArea = 0;

        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();
            right[i] = st.isEmpty() ? n-1 : st.peek() - 1;
            st.push(i);
            maxArea = Math.max(maxArea, heights[i] * (right[i] - left[i] + 1));
        }

        return maxArea;
    }
  
  // Single pass solution
  static int largestRectangleArea2(int histo[]) {
        Stack < Integer > st = new Stack < > ();
        int maxA = 0;
        int n = histo.length;
        for (int i = 0; i <= n; i++) {
            while (!st.empty() && (i == n || histo[st.peek()] >= histo[i])) {
                int height = histo[st.peek()];
                st.pop();
                int width;
                if (st.empty())
                    width = i;
                else
                    width = i - st.peek() - 1;
                maxA = Math.max(maxA, width * height);
            }
            st.push(i);
        }
        return maxA;
    }
}
