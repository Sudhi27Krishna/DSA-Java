package com.company;

import java.util.Map;
import java.util.TreeMap;

public class leetcode {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,3};
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<nums.length; i++){
            int count = 0;
            if(!map.containsKey(nums[i])){
                map.put(nums[i], ++count);
            }
            else{
                int new_count = map.get(nums[i]);
                map.put(nums[i], ++new_count);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println( entry.getKey() + "=>" + entry.getValue() );
        }
    }
//    public int[] frequencySort(int[] nums) {
//
//    }
}
