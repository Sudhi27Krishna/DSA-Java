
// GFG => https://practice.geeksforgeeks.org/problems/e2d156755ca4e0a9b9abf5680191d4b06e52b1a8/0
class GoodStones {
    public static int goodStones(int n, int[] arr) {
        int cnt = 0;
        boolean[] vis = new boolean[n];
        Arrays.fill(vis, true);
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        for(int i=0; i<n; i++){
            if(fun(i, arr, vis, dp)) cnt ++;
        }
        return cnt;
    }
    
    static boolean fun(int i, int[] arr, boolean[] vis, int[] dp){
        if(i < 0 || i > arr.length-1) return true;
        if(arr[i] == 0 || !vis[i]){
            vis[i] = false;
            dp[i] = (vis[i]) ? 1 : 0;
            return vis[i];
        }
        
        if(dp[i] != -1) return (dp[i] == 1);
        
        vis[i] = false;
        
        boolean res = false;
        if(arr[i] > 0){
            res = fun(arr[i] + i, arr, vis, dp);
        }
        
        if(arr[i] < 0){
            int temp = Math.abs(arr[i]);
            res = fun(i - temp, arr, vis, dp);
        }
        
        vis[i] = true;
        
        dp[i] = (res) ? 1 : 0;
        return res;
    }
}
        
