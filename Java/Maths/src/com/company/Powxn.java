package com.company;

public class Powxn {
    public static void main(String[] args) {
        int base = 2;
        int pow = 0;
        int ans = 1;
        while(pow > 0){
            if((pow&1) == 1){
                ans *= base;
            }
            base *= base;
            pow = pow >> 1;
        }
        float minus = (float) 1/ans;
        System.out.println(ans);
        System.out.println(minus);
    }
}
