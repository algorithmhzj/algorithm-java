package com.github.shoothzj.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q0001 {

    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> aux = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (aux.containsKey(target - nums[i])) {
                return new int[] {aux.get(target - nums[i]), i};
            } else {
                aux.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException();
    }

}
