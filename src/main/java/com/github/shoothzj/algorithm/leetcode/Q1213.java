package com.github.shoothzj.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Q1213 {

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i: arr1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i: arr2) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i: arr3) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        map.forEach((integer, integer2) -> {
            if (integer2 > 2) {
                result.add(integer);
            }
        });
        return result;
    }

}
