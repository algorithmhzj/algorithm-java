package com.github.shoothzj.algorithm.leetcode;

import java.util.*;

public class Q1207 {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a: arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (Integer next : map.values()) {
            if (set.contains(next)) {
                return true;
            }
            set.add(next);
        }
        return false;
    }

}
