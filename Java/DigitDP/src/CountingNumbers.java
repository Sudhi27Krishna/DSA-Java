import java.util.Arrays;
import java.util.Scanner;

public class CountingNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String L = in.next(), R = in.next();
        Long l = Long.parseLong(L);
        l--;
        L = String.valueOf(l);
        long[][][][] dp = new long[R.length()+1][11][2][2];
        for(long[][][] d3 : dp) for(long[][] mat : d3) for(long[] row : mat) Arrays.fill(row, -1);
        long ans1 = fun(R, R.length(),-1, 1, 1, dp);
        if(l < 0){
            System.out.println(ans1);
            return;
        }
        for(long[][][] d3 : dp) for(long[][] mat : d3) for(long[] row : mat) Arrays.fill(row, -1);
        long ans2 = fun(L, L.length(), -1, 1, 1, dp);
        System.out.println(ans1 - ans2);
    }

    private static long fun(String num, int n, int prev, int leading, int tight, long[][][][] dp){
        if(n == 0) return 1;

        if(dp[n][prev+1][leading][tight] != -1) return dp[n][prev+1][leading][tight];

        int ub = tight == 1 ? num.charAt(num.length() - n) - '0' : 9;
        long res = 0;

        for(int dig=0; dig<=ub; dig++){
            if(prev == dig && leading == 0) continue;
            res += fun(num, n-1, dig, dig == 0 ? leading : 0, (dig == ub) ? tight : 0, dp);
        }

        return dp[n][prev+1][leading][tight] = res;
    }
}
