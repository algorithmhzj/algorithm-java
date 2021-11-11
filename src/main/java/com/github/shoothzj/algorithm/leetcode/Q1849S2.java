package com.github.shoothzj.algorithm.leetcode;

/**
 * @author hezhangjian
 */
public class Q1849S2 {

    public boolean splitString(String s) {
        char[] charArray = s.toCharArray();
        if (charArray.length < 2) {
            return false;
        }
        return dfs(charArray, 1, -1, charArray[0] - '0');
    }


    /**
     * @param idx
     */
    public boolean dfs(char[] array, int idx, long prev, long sb) {
        // current char append to str
        if (idx == array.length) {
            if (prev != -1) {
                return prev - sb == 1;
            }
            return false;
        }
        boolean case1 = dfs(array, idx + 1, prev, (sb * 10) + (array[idx] - '0'));
        // 终结,得到新的值
        if (prev != -1) {
            if (prev - sb != 1) {
                return case1;
            }
        }
        boolean case2 = dfs(array, idx + 1, sb, array[idx] - '0');
        return case1 || case2;
    }

}
