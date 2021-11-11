package com.github.shoothzj.algorithm.leetcode;

public class Q1186 {

    /**
     * Given an array of integers, return the maximum sum for a non-empty subarray (contiguous elements) with at most one element deletion. In other words, you want to choose a subarray and optionally delete one element from it so that there is still at least one element left and the sum of the remaining elements is maximum possible.
     *
     * Note that the subarray needs to be non-empty after deleting one element.
     * @param arr
     * @return
     */
    public int maximumSum(int[] arr) {
        int del = arr[0];
        int res = arr[0];
        int keep = arr[0];

        for (int i = 1; i < arr.length; i++) {
            del = Math.max(keep, del + arr[i]);
            keep = Math.max(keep + arr[i], arr[i]);
            res = Math.max(res, Math.max(keep, del));
        }

        return res;
    }

}
