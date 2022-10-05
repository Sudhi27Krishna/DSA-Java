package com.company;

public class NewtonSQRT {
    public static void main(String[] args) {
        System.out.println(nsqrt(40));
    }

    private static double nsqrt(double n) {
        double x = n;
        double root;
        while (true) {
            root = 0.5 * (x + (n / x));
            if (Math.abs(root - x) < 0.5) {
                break;
            }
            x = root;
        }
        return root;
    }
}
