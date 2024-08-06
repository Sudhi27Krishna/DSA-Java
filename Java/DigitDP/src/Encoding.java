// Codechef problem link => https://www.codechef.com/problems/ENCODING?tab=statement

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.*;
import java.lang.*;
import java.io.*;

class Encoding
{
    static long MOD = (long)1e9 + 7;
    static long[][][] dp = new long[100001][11][2];
    static long[][] countDp = new long[100001][2];
    static long[] pow= new long[100001];
    static boolean done = false;
    private static long power(long num, long n){

        if(!done){
            pow[0] = 1;
            for(int i=1;i<=100000;i++){
                pow[i] = (10L * pow[i-1]) % MOD;
            }
            done = true;
        }
        return pow[(int)n];
    }

    private static long count(String limit,int n, int tight ){
        if(tight == 0) return power(10, n);
        if(n == 0) return 1;

        if(countDp[n][tight] != -1) return countDp[n][tight];

        int upperBound = limit.charAt(limit.length()-n) -'0';
        long total = 0;

        for(int dig=0;dig<=upperBound;dig++){
            total += count(limit,n-1, dig==upperBound ? 1 : 0);
            total %= MOD;
        }

        return countDp[n][tight] = total;
    }

    private static long solve(String limit,int n, int preDig, int tight){
        if(n == 0) return 0;

        if(dp[n][preDig][tight] != -1) return dp[n][preDig][tight];

        int upperBound = tight ==  1 ? (limit.charAt(limit.length()-n)-'0') : 9;
        long total = 0;
        for(int dig = 0;dig<=upperBound;dig++){
            long score = 0;
            if(dig !=preDig){
                score = (dig * power(10,n-1) * count(limit, n-1, dig == upperBound ? tight : 0)) % MOD;
            }

            total += score  + solve(limit, n-1, dig, dig == upperBound ? tight : 0);
            total %= MOD;
        }

        return dp[n][preDig][tight] = total;
    }

    private static long bruteForce(String limit){
        long pre = 10;
        long total = 0;

        for(int i=0;i<limit.length();i++){
            if(limit.charAt(i)-'0' != pre){
                total = ( total + (limit.charAt(i)-'0') * power(10,limit.length()-i-1)  ) % MOD;
            }

            pre = limit.charAt(i)-'0';
        }

        return total;
    }

    public static void main (String[] args) throws java.lang.Exception
    {

        BufferedReader cin =new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(cin.readLine());

        List<Long> ans = new ArrayList<>();

        while(t-->0){
            String l = cin.readLine().split(" ")[1];
            String r = cin.readLine().split(" ")[1];

            for(long[][] mat : dp){
                for(long[] row : mat){
                    Arrays.fill(row, -1);
                }
            }

            for(long[] row : countDp){
                Arrays.fill(row, -1);
            }

            long rSolve = solve(r, r.length(),10, 1);

            for(long[][] mat : dp){
                for(long[] row : mat){
                    Arrays.fill(row, -1);
                }
            }

            for(long[] row : countDp){
                Arrays.fill(row, -1);
            }

            long lSolve = solve(l , l.length(), 10, 1);

            ans.add((rSolve  - lSolve + bruteForce(l) + MOD ) % MOD);
        }

        for (long num : ans) System.out.println(num);
    }
}
