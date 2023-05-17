package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        System.out.println(subsetDuplicate(a));
    }
    static List<List<Integer>> subset(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int num: arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }
    static List<List<Integer>> subsetDuplicate(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for (int i=0;i<arr.length;i++) {
            start = 0;
            if(i>0 && arr[i] == arr[i-1]){
                start =  end + 1;
            }
            end = outer.size() - 1;
            int n = outer.size();
            for (int j = start; j < n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }
}

class Subset_I {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        fun(0, nums, ans, new ArrayList<>());
        return ans;
    }

    public void fun(int ind, int[] nums, List<List<Integer>> list, List<Integer> p){
        list.add(new ArrayList<>(p));
        for(int i=ind; i<nums.length; i++){
            p.add(nums[i]);
            fun(i+1, nums, list, p);
            p.remove(p.size()-1);
        }
    }
}

class Subset_II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        fun(0, nums, ans, new ArrayList<>());
        return ans;
    }

    public void fun(int ind, int[] nums, List<List<Integer>> list, List<Integer> p){
        list.add(new ArrayList<>(p));
        for(int i=ind; i<nums.length; i++){
            if(i != ind && nums[i] == nums[i-1]) continue;
            p.add(nums[i]);
            fun(i+1, nums, list, p);
            p.remove(p.size()-1);
        }
    }
}
