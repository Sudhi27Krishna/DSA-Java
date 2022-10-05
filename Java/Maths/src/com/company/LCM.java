package com.company;

public class LCM {
    public static void main(String[] args) {
        System.out.println(lcm(3,7));
    }
    static int lcm(int a,int b){
        // or return a*b/gcd(a,b);  because a*b = lcm(a,b) * gcd(a,b)
        int d = gcd(a,b);
        int f = a/d;
        int g = b/d;
        return f*g*d;
    }
    static int gcd(int a,int b){
        if(a == 0){
            return b;
        }
        return gcd((b%a),a);
    }
}
