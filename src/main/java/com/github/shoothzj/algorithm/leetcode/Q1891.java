package com.github.shoothzj.algorithm.leetcode;

/**
 * @author hezhangjian
 */
public class Q1891 {

    public int maxLength(int[] ribbons, int k) {
        int right = 0;
        for (int ribbon : ribbons) {
            right = Math.max(ribbon, right);
        }
        int left = 1;
        int mid = (left + right) / 2;
        while (mid < right) {
            if (isFeasible(ribbons, k, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
            mid = left + (right - left) / 2;
        }
        if (isFeasible(ribbons, k, left)) {
            return left;
        }
        return left - 1;
    }

    private boolean isFeasible(int[] ribbons, int k, int length) {
        int sum = 0;
        for (int ribbon : ribbons) {
            sum += ribbon / length;
            if (sum >= k) {
                return true;
            }
        }
        return false;
    }

}
