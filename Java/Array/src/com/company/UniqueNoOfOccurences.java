package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class UniqueNoOfOccurences {
    public static void main(String[] args) {
        int[] arr = {1,2,2,1,1,3};
        System.out.printf(uniqueOccurrences(arr));
    }
    public static String uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
        int cnt = 0;
        for(int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                int temp = map.get(arr[i]);
                map.put(arr[i],++temp);
            }
            else{
                map.put(arr[i],0);
            }
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            list.add(entry.getValue());
        }

        Collections.sort(list);

        for(int i=1; i<list.size(); i++){
            if(list.get(i-1) == list.get(i)){
                return "false";
            }
        }

        return "true";
    }
}
