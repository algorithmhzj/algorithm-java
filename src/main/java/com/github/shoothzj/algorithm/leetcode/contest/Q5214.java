package com.github.shoothzj.algorithm.leetcode.contest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q5214 {

    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> res = new HashMap<>();
        int result = 0;
        for (int i : arr) {
            int beforeKey = i - difference;
            Integer integer = res.get(beforeKey);
            if (integer != null) {
                res.remove(beforeKey);
                res.put(i, integer + 1);
                result = Math.max(result, integer + 1);
            } else {
                if (!res.containsKey(i)) {
                    res.put(i, 1);
                    result = Math.max(result, 1);
                }
            }
        }
        return result;
    }

    public int longestSubsequenceError(int[] arr, int difference) {
        Set<Integer> procSet = new HashSet<>();
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i : arr) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }

        difference = Math.abs(difference);

        Arrays.sort(arr);

        int maxLength = 0;

        for (int i : arr) {

            if (procSet.contains(i)) {
                continue;
            }

            int temp = i;
            int length = 0;
            //handle for integer i
            while (true) {
                Integer count = countMap.get(temp);
                if (count != null && count != 0) {
                    length++;
                    procSet.add(temp);
                    countMap.put(temp, count - 1);
                } else {
                    break;
                }
                temp = temp + difference;
            }
            maxLength = Math.max(maxLength, length);

        }

        return maxLength;
    }

}
