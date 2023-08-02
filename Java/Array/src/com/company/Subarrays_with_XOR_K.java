// Code Studio link => https://www.codingninjas.com/studio/problems/subarrays-with-xor-k_6826258?leftPanelTab=0
import java.util.HashMap;
import java.util.Map;

public class Subarrays_with_XOR_K {
    public static int subarraysWithSumK(int []a, int k) {
        int n = a.length; //size of the given array.
        int xr = 0;
        Map<Integer, Integer> map = new HashMap<>(); //declaring the map.
        map.put(xr, 1); //setting the value of 0.
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            // prefix XOR till index i:
            xr = xr ^ a[i];

            //By formula: x = xr^k:
            int x = xr ^ k;

            // add the occurrence of xr^k
            // to the count:
            if (map.containsKey(x)) {
                cnt += map.get(x);
            }

            map.put(xr, map.getOrDefault(xr, 0) + 1);
        }
        return cnt;
    }
}
