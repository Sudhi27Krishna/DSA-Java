// Leetcode link => https://leetcode.com/problems/wiggle-subsequence/description/?envType=list&envId=9nj5345h

class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length <= 1) return 1;
        if(nums.length == 2) return nums[0] != nums[1] ? 2 : 1;

        int ans = 0;
        int n = nums.length;
        int[][][] dp = new int[n][1001][2];
        for(int[][] mat : dp) for(int[] row : mat) Arrays.fill(row, -1);
        ans = fun(1, nums, nums[0], 1, dp);
        ans = Math.max(ans, fun(1, nums, nums[0], 0, dp));
        return ans+1;
    }

    int fun(int ind, int[] nums, int prev, int wig, int[][][] dp){
        if(ind == nums.length) return 0;

        if(dp[ind][prev][wig] != -1) return dp[ind][prev][wig];

        int res = 0;
        if(wig == 1){
            if(prev < nums[ind]){
                res = 1 + fun(ind+1, nums, nums[ind], 0, dp);
                res = Math.max(res, fun(ind+1, nums, prev, wig, dp));
            }
            else res = fun(ind+1, nums, prev, wig, dp);
        }
        else{
            if(prev > nums[ind]){
                res = 1 + fun(ind+1, nums, nums[ind], 1, dp);
                res = Math.max(res, fun(ind+1, nums, prev, wig, dp));
            }
            else res = fun(ind+1, nums, prev, wig, dp);
        }

        return dp[ind][prev][wig] = res;
    }

  // Tabulation
    public int wiggleMaxLengthTabulation(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int[][][] dp = new int[n+1][1001][2];
        
        // Optional as dp is intialized with all zeroes
        for(int i=0; i<1001; i++){
            for(int j=0; j<2; j++){
                dp[n][i][j] = 0;
            }
        }

        for(int ind=n-1; ind>=0; ind--){
            for(int prev=1000; prev>=0; prev--){
                for(int wig=0; wig<2; wig++){
                    int res = 0;
                    if(wig == 1){
                        if(prev < nums[ind]){
                            res = 1 + dp[ind+1][nums[ind]][0];
                            res = Math.max(res, dp[ind+1][prev][wig]);
                        }
                        else res = dp[ind+1][prev][wig];
                    }
                    else{
                        if(prev > nums[ind]){
                            res = 1 + dp[ind+1][nums[ind]][1];
                            res = Math.max(res, dp[ind+1][prev][wig]);
                        }
                        else res = dp[ind+1][prev][wig];
                    }

                    dp[ind][prev][wig] = res;
                }
            }
        }

        ans = dp[1][nums[0]][1];
        ans = Math.max(ans, dp[1][nums[0]][0]);
        return ans+1;
    }

  // Space optimized
    public int wiggleMaxLength_sp_opt(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int[][] front = new int[1001][2];
        
        // Optional as dp is intialized with all zeroes
        for(int i=0; i<1001; i++){
            for(int j=0; j<2; j++){
                front[i][j] = 0;
            }
        }

        for(int ind=n-1; ind>=0; ind--){
            int[][] back = new int[1001][2];
            for(int prev=1000; prev>=0; prev--){
                for(int wig=0; wig<2; wig++){
                    int res = 0;
                    if(wig == 1){
                        if(prev < nums[ind]){
                            res = 1 + front[nums[ind]][0];
                            res = Math.max(res, front[prev][wig]);
                        }
                        else res = front[prev][wig];
                    }
                    else{
                        if(prev > nums[ind]){
                            res = 1 + front[nums[ind]][1];
                            res = Math.max(res, front[prev][wig]);
                        }
                        else res = front[prev][wig];
                    }

                    back[prev][wig] = res;
                }
            }
            front = back;
        }

        ans = front[nums[0]][1];
        ans = Math.max(ans, front[nums[0]][0]);
        return ans+1;
    }
}
