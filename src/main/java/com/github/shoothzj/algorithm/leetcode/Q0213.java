package com.github.shoothzj.algorithm.leetcode;

/**
 * @author shoothzj
 */
public class Q0213 {

    /**
     * dp
     * do[i] is the house's max rob
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length -1));
    }

    /**
     * dp
     * do[i] is the house's max rob
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums, int start, int end) {
        if (end == start) {
            return nums[start];
        }
        if (end - start == 1) {
            return Math.max(nums[start], nums[end]);
        }
        int[] dp = new int[end - start + 1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i - start] = Math.max(dp[i - start - 1], dp[i - start - 2] + nums[i]);
        }
        return dp[end - start];
    }

}
