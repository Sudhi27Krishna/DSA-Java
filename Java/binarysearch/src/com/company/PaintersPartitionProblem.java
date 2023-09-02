// InterviewBit link => https://www.interviewbit.com/problems/painters-partition-problem/

public class PaintersPartitionProblem {
    private static final int MOD = 10000003;
    public int paint(int A, int B, ArrayList<Integer> C) {
        long start = 0, end = 0;
        for(int num : C){
            start = Math.max(start, num);
            end += num;
        }
        
        while(start < end){
            long mid = start + (end - start) / 2;
            
            int sum = 0, p = 1;
            for(int board : C){
                if(sum + board > mid){
                    p++;
                    sum = board;
                }
                else{
                    sum += board;
                }
            }
            
            if(p > A){
                start = mid + 1;
            }
            else end = mid;
        }
        
        return (int)((end*B)%MOD);
    }
}
