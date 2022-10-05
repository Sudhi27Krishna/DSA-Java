package com.company;

public class MissingNum {
    public static void main(String[] args) {

    }

    static void swap(int[] a, int first, int second) {
        int temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }

    static int cyc_sort(int[] a) {
        int i = 0;
        while (i < a.length) {
            int correct = a[i];
            if (a[i] < a.length && a[correct] != a[i]) {
                swap(a, correct, i);
            } else {
                i++;
            }
        }
        for (int j = 0; j < a.length; j++) {
            if(a[j] != j){
                return j;
            }
        }
        return a.length;
    }
}
