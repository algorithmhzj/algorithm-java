package com.github.shoothzj.algorithm.leetcode;

public class Q1021 {

    public String removeOuterParentheses(String S) {
        int depth = 0;
        char[] charArray = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ch: charArray) {
            if (ch == '(') {
                depth++;
            }
            if (depth > 1) {
                sb.append(ch);
            }
            if (ch == ')') {
                depth--;
            }
        }
        return sb.toString();
    }

}
