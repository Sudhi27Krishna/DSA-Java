package com.company;

public class SquareRootBinary {
    public static void main(String[] args) {
        int n = 2147395600;
        int p = 4;
        System.out.printf("%f",sqrt(n,p));
        System.out.println();
        System.out.println((int)sqrt(n,p));
    }

    private static double sqrt(int n, int p) {
        int start = 0;
        int end = n;
        double root = 0;
        while (start <= end){
            int mid = start + (end-start) / 2;
            if(mid*mid == n){
                root = mid;
                return root;
            }
            if(mid*mid > n){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
            double incr = 0.1;
            for (int i = 0; i < p; i++) {
                while (root*root <= n){
                    root += incr;
                }
                root = root - incr;
                incr = incr / 10;
            }
        }
        return root;
    }
}
