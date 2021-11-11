package com.github.shoothzj.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hezhangjian
 */
public class Q1849 {

    public boolean splitString(String s) {
        char[] charArray = s.toCharArray();
        if (charArray.length < 2) {
            return false;
        }
        final ArrayList<Long> integers = new ArrayList<>();
        return dfs(charArray, 1, integers, charArray[0] - '0');
    }


    /**
     * @param idx
     */
    public boolean dfs(char[] array, int idx, List<Long> currentInts, long sb) {
        // current char append to str
        if (idx == array.length) {
            final ArrayList<Long> integers = new ArrayList<>(currentInts);
            if (integers.size() != 0) {
                final Long lastInteger = integers.get(integers.size() - 1);
                return lastInteger - sb == 1;
            }
            return false;
        }
        boolean case1 = dfs(array, idx + 1, new ArrayList<>(currentInts), (sb * 10) + (array[idx] - '0'));
        // 终结,得到新的值
        if (currentInts.size() != 0) {
            if (currentInts.get(currentInts.size() - 1) - sb != 1) {
                return case1;
            }
        }
        // 这里可以省略一次值拷贝，不过如果省略，会容易让人引起困惑
        ArrayList<Long> arrayList = new ArrayList<>(currentInts);
        arrayList.add(sb);
        boolean case2 = dfs(array, idx + 1, arrayList, array[idx] - '0');
        return case1 || case2;
    }

}
