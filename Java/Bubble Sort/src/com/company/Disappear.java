package com.company;

import java.util.ArrayList;
import java.util.List;

public class Disappear {
    public static void main(String[] args) {

    }
    static void swap(int[] a, int first, int second) {
        int temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }

    static List<Integer> cyc_sort(int[] a) {
        int i = 0;
        while (i < a.length) {
            int correct = a[i] - 1;
            if (a[correct] != a[i]) {
                swap(a, correct, i);
            } else {
                i++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int index = 0; index < a.length; index++) {
            if(a[index] != index + 1 ){
                ans.add(index+1);
            }
        }
        return ans;
    }
}
