package com.github.shoothzj.algorithm.leetcode;

import java.util.Stack;

public class Q0020 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        try {
            char[] charArray = s.toCharArray();
            for (char ch : charArray) {
                switch (ch) {
                    case '(':
                        stack.push(ch);
                        break;
                    case ')':
                        Character character = stack.pop();
                        if (character == null || character != '(') {
                            return false;
                        }
                        break;
                    case '{':
                        stack.push(ch);
                        break;
                    case '}':
                        Character character2 = stack.pop();
                        if (character2 == null || character2 != '{') {
                            return false;
                        }
                        break;
                    case '[':
                        stack.push(ch);
                        break;
                    case ']':
                        Character character3 = stack.pop();
                        if (character3 == null || character3 != '[') {
                            return false;
                        }
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return stack.size() == 0;
    }

}
