package com.github.shoothzj.algorithm.leetcode;

/**
 * We are given an array A of N lowercase letter strings, all of the same length.
 * Now, we may choose any set of deletion indices, and for each string, we delete all the characters in those indices.
 * For example, if we have an array A = ["abcdef","uvwxyz"] and deletion indices {0, 2, 3}, then the final array after deletions is ["bef", "vyz"], and the remaining columns of A are ["b","v"], ["e","y"], and ["f","z"].  (Formally, the c-th column is [A[0][c], A[1][c], ..., A[A.length-1][c]].)
 * Suppose we chose a set of deletion indices D such that after deletions, each remaining column in A is in non-decreasing sorted order.
 * Return the minimum possible value of D.length.
 */
public class Q0944 {

    public int minDeletionSize(String[] A) {
        if (A.length < 2) {
            return 0;
        }
        if (A[0].length() < 1) {
            return 0;
        }
        int res = A[0].length();
        for (int i = 0; i < A[0].length(); i++) {
            boolean ojbk = true;
            for (int j = 1; j < A.length; j++) {
                if (A[j].charAt(i) < A[j - 1].charAt(i)) {
                    ojbk = false;
                    break;
                }
            }
            if (ojbk) {
                res--;
            }
        }
        return res;
    }

}
