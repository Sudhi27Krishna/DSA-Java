package com.company;

public class SievePrime {
    public static void main(String[] args) {
        int n = 50;
        boolean[] primes = new boolean[n+1];
        sieve(primes,n);

    }
    static void sieve(boolean[] primes,int n){
        for (int i = 2; i*i <= n ; i++) {
            if(!primes[i]){
                for (int j = 2*i; j <= n; j = j + i) {
                    primes[j] = true;
                }
            }
        }
        for (int i = 2; i <= n ; i++) {
            if(!primes[i]){
                System.out.print(i + " ");
            }
        }
    }
}
