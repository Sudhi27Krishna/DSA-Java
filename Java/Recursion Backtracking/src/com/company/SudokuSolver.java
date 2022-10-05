package com.company;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {3,0,6,5,0,8,4,0,0},
                {5,2,0,0,0,0,0,0,0},
                {0,8,7,0,0,0,0,3,1},
                {0,0,3,0,1,0,0,8,0},
                {9,0,0,8,6,3,0,0,5},
                {0,5,0,0,9,0,6,0,0},
                {1,3,0,0,0,0,2,5,0},
                {0,0,0,0,0,0,0,7,4},
                {0,0,5,2,0,6,3,0,0}
        };
       if(solve(board)){
           display(board);
       }else {
           System.out.println("Cannot solve.");
       }
    }
    static boolean solve(int[][] board){
        int n = board.length;
        int row = -1;
        int col = -1;
        boolean empty = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 0){
                    row = i;
                    col = j;
                    empty = false;
                    break;
                }
            }
            if(!empty){
                break;
            }
        }
        if(empty){
            return true;
        }
        for (int number = 1; number <= 9 ; number++) {
            if(isSafe(board,row,col,number)){
                board[row][col] = number;
                if(solve(board)){
                    return true;
                }else {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    private static void display(int[][] board) {
        for (int[] row : board) {
            for (int i : row) {
                System.out.print(i+ " ");
            }
            System.out.println();
        }
    }

    static boolean isSafe(int[][] board,int row,int col,int num){
        //check the row
        for (int i = 0; i < board.length; i++) {
            if(board[row][col] == num){
                return false;
            }
        }
        //check the col
        for (int[] nums : board) {
            if(nums[col] == num){
                return false;
            }
        }
        int sq = (int)Math.sqrt(board.length);
        int rowStart = row - (row % sq);
        int colStart = col - (col % sq);

        for (int r = rowStart; r < rowStart + sq; r++) {
            for (int c = colStart; c < colStart + sq; c++) {
                if(board[r][c] == num){
                    return false;
                }
            }
        }
        return true;
    }
}
