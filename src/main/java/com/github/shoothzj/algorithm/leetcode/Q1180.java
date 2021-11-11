package com.github.shoothzj.algorithm.leetcode;

public class Q1180 {

    public int countLetters(String S) {
        int result = 0;
        int auxCount = 0;
        char lastChar = 'A';
        char[] charArray = S.toCharArray();
        for (char ch : charArray) {
            if (ch == lastChar) {
                auxCount++;
            } else {
                result += cal(auxCount);
                auxCount = 1;
                lastChar = ch;
            }
        }
        result += cal(auxCount);
        return result;
    }

    private int cal(int count) {
        return count * (count + 1) / 2;
    }

}
