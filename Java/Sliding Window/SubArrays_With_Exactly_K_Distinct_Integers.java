// InterviewBit link => https://www.interviewbit.com/problems/subarrays-with-distinct-integers/
// InterviewBit link => https://www.interviewbit.com/problems/subarray-with-b-odd-numbers/

public class SubArrays_With_Distinct_Integers {
    public int solve(ArrayList<Integer> A, int B) {
        return atMostK(A, B) - atMostK(A, B - 1);
    }
    
    private int atMostK(ArrayList<Integer> A, int K) {
        int i = 0, j = 0, n = A.size(), cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        while(j < n){
            int num = A.get(j);
            map.put(num, map.getOrDefault(num, 0) + 1);
            
            while(map.size() > K){
                map.put(A.get(i), map.get(A.get(i)) - 1);
                if(map.get(A.get(i)) == 0) map.remove(A.get(i));
                i++;
            }
            
            cnt += (j-i+1);
            j++;
        }
        
        return cnt;
    }
}
