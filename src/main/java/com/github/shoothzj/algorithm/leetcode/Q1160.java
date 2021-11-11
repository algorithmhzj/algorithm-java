package com.github.shoothzj.algorithm.leetcode;

public class Q1160 {

    public int countCharacters(String[] words, String chars) {
        int[] countArray = new int[26];
        char[] charArray = chars.toCharArray();
        for (char c : charArray) {
            countArray[c - 'a']++;
        }
        int result = 0;
        for (String word : words) {
            char[] wordArray = word.toCharArray();
            int[] compareArray = new int[26];
            for (int j = 0; j < wordArray.length; j++) {
                int index = wordArray[j] - 'a';
                compareArray[index]++;
                if (compareArray[index] > countArray[index]) {
                    break;
                }
                if (j == wordArray.length - 1) {
                    result += word.length();
                }
            }
        }

        return result;
    }

}
