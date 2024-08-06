import java.util.Arrays;

/**
Problem: Boring Number
Ron read a book about boring numbers. According to the book, a positive number is called boring if all of the digits at even positions in the number are even and all of the digits at odd positions are odd. The digits are enumerated from left to right starting from 1. For example, the number 1478 is boring as the odd positions include the digits {1, 7} which are odd and even positions include the digits {4, 8} which are even.
Given two numbers L and R, Ron wants to count how many numbers in the range [L, R] (L and R inclusive) are boring. Ron is unable to solve the problem, hence he needs your help.

Input
The first line of the input gives the number of test cases, T. T test cases follow. Each test case consists of a single line with two numbers L and R.

Output
For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the count of boring numbers.

Limits
Time limit: 20 seconds.
Memory limit: 1 GB.
1 ≤ T ≤ 100.
Test set 1
1 ≤ L ≤ R ≤ 10^3.
Test set 2
1 ≤ L ≤ R ≤ 10^18.

Sample
Input:
3
5 15
120 125
779 783
Output:
Case #1: 6
Case #2: 3
Case #3: 2
Explanation

In Sample Case #1, the numbers in the range are {5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15} out of which {5, 7, 9, 10, 12, 14} are boring, hence the answer is 6.
In Sample Case #2, the numbers in the range are {120, 121, 122, 123, 124, 125} out of which {121, 123, 125} are boring, hence the answer is 3.
In Sample Case #3, the numbers in the range are {779, 780, 781, 782, 783} out of which {781, 783} are boring, hence the answer is 2.
*/
public class BoringNumbers {
    public static void main(String[] args) {
        int[][][][] dp = new int[20][2][2][2];
        String L = "779", R = "783";
        Integer l = Integer.parseInt(L);
        l--;
        L = String.valueOf(l);
        for(int[][][] d3 : dp) for(int[][] mat : d3) for(int[] row : mat) Arrays.fill(row, -1);
        int ans1 = fun(R, R.length(), 0, 1, 1, dp);
        for(int[][][] d3 : dp) for(int[][] mat : d3) for(int[] row : mat) Arrays.fill(row, -1);
        int ans2 = fun(L, L.length(), 0, 1, 1, dp);
        System.out.println(ans1 - ans2);
    }

    private static int fun(String num, int n, int even, int leading, int tight, int[][][][] dp){
        if(n == 0) return 1;

        if(dp[n][even][leading][tight] != -1) return dp[n][even][leading][tight];

        int res = 0;
        int ub = tight == 1 ? num.charAt(num.length() - n) - '0' : 9;
        if(even == 1){
            for(int dig=0; dig<=8; dig+=2){
                if(dig <= ub) res += fun(num, n-1, 0, 0, dig == ub ? tight : 0, dp);
            }
        }
        else{
            if(leading == 1){
                res += fun(num, n-1, 0, 1, 0, dp);
            }

            for(int dig=1; dig<=9; dig+=2){
                if(dig <= ub) res += fun(num, n-1, 1, 0, dig == ub ? tight : 0, dp);
            }
        }
        return dp[n][even][leading][tight] = res;
    }
}
