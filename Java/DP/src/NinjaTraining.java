// Code Studio Problem
import java.util.Arrays;

import java.util.* ;
public class NinjaTraining {
    public static int ninjaTraining(int n, int[][] points) {
        int[][] dp = new int[n][points[0].length+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        return fun(n-1,points[0].length, points, dp);
    }

    public static int fun(int day, int last, int[][] points, int[][] dp){
        if(dp[day][last] != -1){
            return dp[day][last];
        }

        if(day == 0){
            int max = 0;
            for(int i=0; i<points[0].length; i++){
                if(i != last){
                    max = Math.max(max, points[day][i]);
                }
            }
            return dp[day][last] = max;
        }

        int max = 0;
        for(int i=0; i<points[0].length; i++){
            int point = 0;
            if(i != last){
                point = points[day][i] + fun(day-1, i, points, dp);
                max = Math.max(max, point);
            }
        }

        return dp[day][last] = max;
    }

    public static int ninjaTraining_tabulation(int n, int[][] points) {


        int[][] dp = new int[n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        int activity = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }

        }

        return dp[n - 1][3];
    }

    public static int ninjaTraining_sp_opt(int n, int[][] points) {


        int prev[] = new int[4];

        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {

            int temp[] = new int[4];
            for (int last = 0; last < 4; last++) {
                temp[last] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        temp[last] = Math.max(temp[last], points[day][task] + prev[task]);
                    }
                }
            }

            prev = temp;

        }

        return prev[3];
    }

}
