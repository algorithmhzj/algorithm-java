package com.github.shoothzj.algorithm.nowcoder;

public class Bm78 {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
        }
        return dp[nums.length];
    }

}
