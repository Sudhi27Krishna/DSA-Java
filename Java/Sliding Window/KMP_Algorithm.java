package com.company;

public class KMP_Algorithm {
    public static void main(String[] args) {
        String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";
        System.out.println(KMP(str.toCharArray(), subString.toCharArray()));
    }

    private static int[] generateLPS(char[] pattern){
        int[] lps = new int[pattern.length];
        int j = 0, i = 1;

        while(i < pattern.length){
            if(pattern[j] == pattern[i]){
                lps[i] = j + 1;
                j++;
                i++;
            }
            else{
                if(j != 0){
                    j = lps[j-1];
                }
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    private static int KMP(char[] text, char[] pattern){
        int i = 0, j = 0;

        int[] lps = generateLPS(pattern);
        while(i < text.length && j < pattern.length){
            if(text[i] == pattern[j]){
                i++;
                j++;
            }
            else{
                if(j != 0){
                    j = lps[j-1];
                }
                else{
                    i++;
                }
            }

            if(j == pattern.length) return i - pattern.length;
        }

        return -1;
    }
}
