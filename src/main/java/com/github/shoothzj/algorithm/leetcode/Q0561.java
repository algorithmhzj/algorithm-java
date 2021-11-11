package com.github.shoothzj.algorithm.leetcode;

import java.util.Arrays;

public class Q0561 {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i+=2) {
            res += nums[i];
        }
        return res;
    }

}
