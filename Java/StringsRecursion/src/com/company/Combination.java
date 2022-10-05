package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Combination {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(combinationSum(arr,4));

    }
    public static ArrayList<ArrayList<Integer>> combinationSum(int[] arr, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        combi(ans,new ArrayList<>(),target,arr,0);
        return ans;
    }

    private static void combi(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> p, int target, int[] arr, int start) {
        if(target == 0){
            ans.add(new ArrayList<>(p));
            return;
        }
        for (int i = start; i < arr.length && arr[i] <= target; i++) {
            p.add(arr[i]);
            combi(ans,p,target - arr[i],arr,i);// not i + 1 because we can reuse same elements
            p.remove(p.size()-1);
        }
    }

    private static void combi2NoReuse(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> p, int target, int[] arr, int start) {
        if(target == 0){
            ans.add(new ArrayList<>(p));
            return;
        }
        for (int i = start; i < arr.length && arr[i] <= target; i++) {
            if(i > start && arr[i] == arr[i-1]){
                continue;
            }
            p.add(arr[i]);
            combi(ans,p,target - arr[i],arr,i+1);
            p.remove(p.size()-1);
        }
    }
}
