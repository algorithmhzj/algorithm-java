package com.github.shoothzj.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author hezhangjian
 */
public class Q1099 {

    /**
     * @param nums
     * @param k
     * @return
     */
    public int twoSumLessThanK(int[] nums, int k) {
        // sort the array
        Arrays.sort(nums);
        int answer = -1;
        // set the left to zero, right is less than k
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < k) {
                answer = Math.max(answer, sum);
                left++;
            } else {
                right--;
            }
        }
        return answer;
    }

}
