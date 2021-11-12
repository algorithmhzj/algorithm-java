package com.github.shoothzj.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author hezhangjian
 */
public class Q1966 {

    public int binarySearchableNumbers(int[] nums) {
        int n = nums.length;
        int ans = 0;
        boolean[] valid = new boolean[n];
        Arrays.fill(valid, false);


        int currMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] > currMax) {
                valid[i] = true;
            }
            currMax = Math.max(currMax, nums[i]);
        }


        int currMin = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < currMin && valid[i]) {
                ans++;
            }
            currMin = Math.min(currMin, nums[i]);
        }
        return ans;
    }

}
