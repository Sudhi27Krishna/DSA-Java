package com.company;

import java.util.ArrayList;

public class MazePathDiagonal {
    public static void main(String[] args) {
//        System.out.println(pathListDiagonal("",3,3));
        boolean[][] board = {
                {true,true,true},
                {true,false,true},
                {true,true,true}
        };
        System.out.println(pathListObstacles("",board,0,0));
    }
    static ArrayList<String> pathListDiagonal(String p, int r, int c){
        if(r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        if(r > 1 && c >1){
            ans.addAll(pathListDiagonal(p + 'D',r - 1,c - 1));
        }
        if(r > 1){
            ans.addAll(pathListDiagonal(p + 'V',r - 1,c));
        }
        if(c > 1) {
            ans.addAll(pathListDiagonal(p + 'H', r, c - 1));
        }
        return ans;
    }
    static ArrayList<String> pathListObstacles(String p,boolean[][] maze, int r, int c){
        ArrayList<String> list = new ArrayList<>();
        if(r == maze.length - 1 && c == maze[0].length - 1){

            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        if(!maze[r][c]){
            return list;
        }
        if(r < maze.length - 1){
            ans.addAll(pathListObstacles(p + 'D',maze,r + 1,c));
        }
        if(c < maze[0].length - 1) {
            ans.addAll(pathListObstacles(p + 'R',maze, r, c + 1));
        }
        return ans;
    }
}
