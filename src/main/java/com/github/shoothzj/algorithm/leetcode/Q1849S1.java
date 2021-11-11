package com.github.shoothzj.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hezhangjian
 */
public class Q1849S1 {

    public boolean splitString(String s) {
        char[] charArray = s.toCharArray();
        if (charArray.length < 2) {
            return false;
        }
        final ArrayList<Long> integers = new ArrayList<>();
        final StringBuilder stringBuilder = new StringBuilder();
        return dfs(charArray, 1, integers, stringBuilder.append(charArray[0]));
    }


    /**
     * @param idx
     */
    public boolean dfs(char[] array, int idx, List<Long> currentInts, StringBuilder sb) {
        final String string = sb.toString();
        // current char append to str
        if (idx == array.length) {
            final ArrayList<Long> integers = new ArrayList<>(currentInts);
            if (sb.length() > 0) {
                if (integers.size() != 0) {
                    final char[] charArray = sb.toString().toCharArray();
                    long result = 0;
                    for (char c : charArray) {
                        result = result * 10 + (c - '0');
                    }
                    Long integer = result;
                    final Long lastInteger = integers.get(integers.size() - 1);
                    return lastInteger - integer == 1;
                }
                return false;
            }
            return integers.size() > 1;
        }
        boolean case1 = dfs(array, idx + 1, new ArrayList<>(currentInts), sb.append(array[idx]));
        // 终结这个stringbuilder
        // 得到新的值
        if (sb.length() == 0) {
            return case1;
        }
        final char[] charArray = string.toCharArray();
        long result = 0;
        for (char c : charArray) {
            result = result * 10 + (c - '0');
        }
        long integer = result;
        if (currentInts.size() != 0) {
            if (currentInts.get(currentInts.size() - 1) - integer != 1) {
                return case1;
            }
        }
        // 这里可以省略一次值拷贝，不过如果省略，会容易让人引起困惑
        ArrayList<Long> arrayList = new ArrayList<>(currentInts);
        arrayList.add(integer);
        StringBuilder stringBuilder = new StringBuilder().append(array[idx]);
        boolean case2 = dfs(array, idx + 1, arrayList, stringBuilder);
        return case1 || case2;
    }

}
