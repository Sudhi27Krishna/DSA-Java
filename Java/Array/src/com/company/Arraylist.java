package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Arraylist {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       ArrayList<Integer> list = new ArrayList<>(10);
//        list.add(67);
//        list.add(54);
//        list.add(787);
//        list.add(23);
//        list.add(89);
//        list.add(567);
//
//        System.out.println(list.contains(89));
//        list.set(3,5464);
//        list.remove(1);
//        System.out.println(list);

        for (int i = 0; i < 5; i++) {
            list.add(in.nextInt());
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(list.get(i));
        }
    }
}
