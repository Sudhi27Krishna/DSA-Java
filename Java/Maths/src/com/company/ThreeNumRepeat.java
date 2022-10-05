package com.company;

public class ThreeNumRepeat {
    public static void main(String[] args) {
        int[] arr = {2,3,2,6,2,4,6,4,6,9,5,7,5,5,9,7};
        int sum = 0;
        for (int i:arr) {
            sum += i;
        }
        System.out.println((sum) % 3);
    }
}
