package com.company;

import java.util.ArrayList;

public class Ascii {
    public static void main(String[] args) {
        System.out.println(subseq1("","abc"));
    }
    static void subseqascii(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);

        subseqascii(p+ch,up.substring(1));
        subseqascii(p,up.substring(1));
        subseqascii(p+(ch+0),up.substring(1));
    }
    static ArrayList<String> subseq1(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<String>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);

        ArrayList<String> left = subseq1(p+ch,up.substring(1));
        ArrayList<String> right = subseq1(p,up.substring(1));
        ArrayList<String> mid = subseq1(p+(ch+0),up.substring(1));
        left.addAll(right);
        left.addAll(mid);
        return left;
    }
}
