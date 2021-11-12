package com.github.shoothzj.algorithm.leetcode;

/**
 * @author hezhangjian
 */
public class Q1198 {

    public int smallestCommonElement(int[][] mat) {
        int[] count = new int[10001];
        int n = mat.length;
        int m = mat[0].length;
        for (int j = 0; j < m; j++) {
            for (int[] ints : mat) {
                if (++count[ints[j]] == n) {
                    return ints[j];
                }
            }
        }
        return -1;
    }

}
