// Problem link => https://www.spoj.com/problems/PR003004/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DigitSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        List<Integer> ans = new ArrayList<>();
        while(t-- > 0){
            String L = in.next(), R = in.next();
            Integer l = Integer.parseInt(L);
            l--;
            L = String.valueOf(l);
            int[][][] dp = new int[200][R.length()+1][2];
            for(int[][] mat : dp) for(int[] row : mat) Arrays.fill(row, -1);
            int ans1 = fun(R, 0, R.length(),1, dp);
            for(int[][] mat : dp) for(int[] row : mat) Arrays.fill(row, -1);
            int ans2 = fun(L, 0, L.length(), 1, dp);
            ans.add(ans1 - ans2);
        }
        for(int a : ans){
            System.out.println(a);
        }
    }

    private static int fun(String num, int sum, int n, int tight, int[][][] dp){
        if(n == 0) return sum;

        if(dp[sum][n][tight] != -1) return dp[sum][n][tight];

        int res = 0;
        int ub = tight == 1 ? num.charAt(num.length() - n) - '0' : 9;
        for(int dig=0; dig<=ub; dig++){
            res += fun(num, sum+dig, n-1, (dig == ub) ? tight : 0, dp);
        }

        return dp[sum][n][tight] = res;
    }
}
