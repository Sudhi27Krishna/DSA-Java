package com.company;

public class DoubleTriangle {
    public static void main(String[] args) {
         p28(10);
    }

    static void p31(int n) {
        n = 2 * n;
        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= n; col++) {
                int ans =Math.min(Math.min(row,col),Math.min(n-row,n-col));
                System.out.print(ans + " ");
            }
            System.out.println();
        }
    }

    static void p30(int n) {
        for (int row = 1; row <= n ; row++) {
            int cols = 2 * row - 1;
            int spaces = n - row;
            for (int i = spaces; i > 0 ; i--) {
                System.out.print("  ");
            }
            for (int col = cols; col <= cols ; col++) {
                for (int i = row; i > 0 ; i--) {
                    System.out.print(i + " ");
                }
                if(row > 1){
                    for (int i = 2; i <= row; i++) {
                        System.out.print(i + " ");
                    }
                }
            }
            System.out.println();
        }
    }


    static void p28(int n) {
         for (int row = 0; row < 2 * n; row++) {
             int cols = (row > n) ? 2 * n - row : row;
             int spaces = n - cols;
             for (int i = 0; i < spaces; i++) {
                 System.out.print(" ");
             }
             for (int col = 0; col < cols; col++) {
                 System.out.print( "* ");
             }
             System.out.println();
         }
     }


    static void p5(int n){
        for (int row = 0; row < 2 * n; row++) {
            int cols = (row > n) ? 2 * n - row : row;
            for (int col = 0; col < cols; col++) {
                System.out.print( "* ");
            }
            System.out.println();
        }
    }
}
