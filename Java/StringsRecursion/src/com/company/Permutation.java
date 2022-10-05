package com.company;

import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
        System.out.println(permutation1("","123"));
//        ArrayList<String> ans = permutation1("","abc");
//        System.out.println(ans);
//        Collections.sort(ans);
//        System.out.println(ans);
    }
    static void permutations(String p, String up){
        if(up.isEmpty()){
            System.out.print(p + " ");
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            permutations(f+ch+s,up.substring(1));
        }
    }

    static ArrayList<String> permutation1(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            ans.addAll(permutation1(f+ch+s,up.substring(1)));
        }
        return ans;
    }

    static void permute(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> p, int[] arr){
        if(p.size() == arr.length){
            ans.add(new ArrayList<>(p));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(p.contains(arr[i])){
                continue;
            }
            p.add(arr[i]);
            permute(ans,p,arr);
            p.remove(p.size()-1);
        }
    }

    static void permuteDup(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> p, int[] arr, boolean[] vis){
        if(p.size() == arr.length){
            ans.add(new ArrayList<>(p));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(vis[i]) continue;
            vis[i] = true;
            p.add(arr[i]);
            permuteDup(ans,p,arr,vis);
            vis[i] = false;
            p.remove(p.size()-1);

            while (i + 1 < arr.length && arr[i] == arr[i+1]){
                i++;
            }
        }
    }
    static int permutationsCount(String p, String up){
        if(up.isEmpty()){
            return 1;
        }
        int count = 0;
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i,p.length());
            count += permutationsCount(f+ch+s,up.substring(1));
        }
        return count;
    }

}
