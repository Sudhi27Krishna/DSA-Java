// Code Studio link => https://www.codingninjas.com/studio/problems/aggressive-cows_1082559?leftPanelTab=0

import java.util.*;
public class AgressiveCows {
    public static int aggressiveCows(int []stalls, int k) {
        int ans = 0, n = stalls.length;
        Arrays.sort(stalls);

        int low = 0, high = stalls[n-1];

        while(low <= high){
            int mid = low + (high - low) / 2;
            int last = stalls[0], cows = k-1;
            for(int i=1; i<n; i++){
                if(stalls[i] - last >= mid){
                    cows--;
                    last = stalls[i];
                }
                if(cows <=0) break;
            }

            if(cows <= 0){
                ans = mid;
                low = mid + 1;
            }
            else high = mid - 1;
        }

        return ans;
    }
}
