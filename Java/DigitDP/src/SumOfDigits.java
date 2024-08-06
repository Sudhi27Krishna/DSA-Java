import java.util.Arrays;

public class SumOfDigits {
    public static void main(String[] args) {
//        Find the count of numbers between 0 and limit whose sum of digits = X
        String num = "11235";
        int x = 5, n = num.length();
        int[][][] dp = new int[n+1][x+1][2];
        for(int[][] mat : dp) for(int[] row : mat) Arrays.fill(row, -1);
        System.out.println(fun(num, num.length(), x, 1, dp));
    }

    private static int fun(String num, int n, int x, int tight, int[][][] dp){
        if(n == 0) return x == 0 ? 1 : 0;
        if(x < 0) return 0;

        if(dp[n][x][tight] != -1) return dp[n][x][tight];

        int res = 0;
        int ub = tight == 1 ? (num.charAt(num.length() - n) - '0') : 9;
        for(int dig=0; dig<=ub; dig++){
            res += fun(num, n-1, x-dig, (dig == ub) ? tight : 0, dp);
        }

        return dp[n][x][tight] = res;
    }
}
