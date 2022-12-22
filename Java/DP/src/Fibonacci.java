import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int limit = in.nextInt();
        int[] dp = new int[limit+1];
        Arrays.fill(dp, -1);
        System.out.println(fibo_mem(dp,limit)); // TC: O(N) SC: O(N) recursion stack + O(n) dp array
//        System.out.println(fibo(limit));
        System.out.println(fibo_tab(limit)); // TC: O(N) SC: O(N)
        System.out.println(fibo(limit)); // TC: O(N) SC: O(1)
    }

    public static int fibo_rec(int n){
        if(n <= 1){
            return n;
        }

        return fibo_rec(n - 1) + fibo_rec(n - 2);
    }

    public static int fibo_mem(int[] dp, int n){ // top-down
        if(n <= 1){
            return n;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        return dp[n] = fibo_mem(dp,n - 1) + fibo_mem(dp,n - 2);
    }

    public static int fibo_tab(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i=2; i<dp.length; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static int fibo(int n){
        int prev2 = 0;
        int prev1 = 1;

        if (n <= 1){
            return n;
        }

        for (int i = 2; i <= n; i++){
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
