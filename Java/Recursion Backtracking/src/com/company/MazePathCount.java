package com.company;

import java.util.ArrayList;

public class MazePathCount {
    public static void main(String[] args) {
//        System.out.println(pathcount(3,3));
        System.out.println(pathList("",3,3));
    }
    static int pathcount(int r, int c){
        if(r == 1 || c == 1){
            return 1;
        }
        int left = pathcount(r-1,c);
        int right = pathcount(r,c-1);
        return left + right;
    }
    static void path(String p,int r,int c){
        if(r == 1 && c == 1){
            System.out.println(p);
            return;
        }
        if(r > 1){
            path(p + 'D',r - 1,c);
        }
        if(c > 1) {
            path(p + 'R', r, c - 1);
        }
    }
    static ArrayList<String> pathList(String p, int r, int c){
        if(r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        if(r > 1){
            ans.addAll(pathList(p + 'D',r - 1,c));
        }
        if(c > 1) {
            ans.addAll(pathList(p + 'R', r, c - 1));
        }
        return ans;
    }
}
