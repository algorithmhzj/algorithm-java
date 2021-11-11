package com.github.shoothzj.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Q1394 {

    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.merge(i, 1, Integer::sum);
        }
        Set<Map.Entry<Integer, Integer>> entrySet =
                map.entrySet();
        int result = -1;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : entrySet) {
            if (integerIntegerEntry.getKey().equals(integerIntegerEntry.getValue())) {
                result = Math.max(result, integerIntegerEntry.getValue());
            }
        }
        return result;
    }

}
