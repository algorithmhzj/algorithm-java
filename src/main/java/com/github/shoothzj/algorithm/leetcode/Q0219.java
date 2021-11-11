package com.github.shoothzj.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hezhangjian
 */
public class Q0219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            final int number = nums[i];
            if (!map.containsKey(number)) {
                map.put(number, i);
                continue;
            }
            final Integer integer = map.get(number);
            if (i - integer <= k) {
                return true;
            }
            map.put(number, i);
        }
        return false;
    }

}
