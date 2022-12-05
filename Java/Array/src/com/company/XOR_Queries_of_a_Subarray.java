class XOR_Queries_of_a_Subarray {
    public int[] xorQueries(int[] arr, int[][] queries) {
//         int[] ans = new int[queries.length];     
//         if(arr.length <= 1){
//             for(int i=0; i<queries.length; i++){
//                 ans[i] = arr[0];
//             }
//         }
        
//         for(int i=0; i<queries.length; i++){
//             int temp = 0;
//             for(int j=queries[i][0]; j<=queries[i][1]; j++){
//                 temp = temp ^ arr[j];
//             }
//             ans[i] = temp;
//             temp = 0;
//         }
        
//         return ans;  
        // prefix xor array
        for(int i=1; i<arr.length; i++){
            arr[i] ^= arr[i-1];
        }
        
        int[] ans = new int[queries.length];
        // xor pos i to j == arr[i-1] ^ arr[j]  
        for(int i=0; i<queries.length; i++){
            if(queries[i][0] == 0){
                ans[i] = arr[queries[i][1]];
            }
            else{
                ans[i] = arr[queries[i][0]-1] ^ arr[queries[i][1]];
            }
        }
        
        return ans;
    }
}
