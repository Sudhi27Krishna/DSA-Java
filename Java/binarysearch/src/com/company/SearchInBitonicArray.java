// InterviewBit link => https://www.interviewbit.com/problems/search-in-bitonic-array/

public class SearchInBitonicArray {
    public int solve(ArrayList<Integer> A, int B) {
        int p = peak(A);
        int ans = binarySearch(A, B, 0, p, 1);
        if(ans != -1) return ans;
        return binarySearch(A, B, p+1, A.size()-1, 0);
    }
    
    int binarySearch(ArrayList<Integer> A, int B, int start, int end, int flag){
        while(start <= end){
            int mid = start + (end - start) / 2;
            
            if(A.get(mid) == B) return mid;
            
            if(flag == 1){
                if(A.get(mid) > B){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }   
            }
            else{
                if(A.get(mid) < B){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
        }
        
        return -1;
    }
    
    int peak(ArrayList<Integer> A){
        int start = 0, end = A.size()-1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            
            int left = mid - 1 < 0 ? A.size()-1 : mid - 1;
            int right = mid + 1 == A.size() ? 0 : mid + 1;
            
            if(A.get(left) < A.get(mid) && A.get(mid) > A.get(right)) return mid;
            
            if(A.get(mid) < A.get(left)){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        
        return -1;
    }
}
