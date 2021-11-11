package com.github.shoothzj.algorithm.leetcode.contest;

import java.util.TreeMap;

public class Q5225 {

    public int maxEqualFreq(int[] nums) {
        int res = 0;
        int[] counts = new int[100000 + 1];
        TreeMap<Integer, Integer> m = new TreeMap<>(); //count to "count of the same count"
        for (int i = 0; i < nums.length; i++) {
            if (counts[nums[i]] > 0) {
                int cc = m.get(counts[nums[i]]);
                if (cc == 1)
                    m.remove(counts[nums[i]]);
                else
                    m.put(counts[nums[i]], cc - 1);
            }
            counts[nums[i]]++;
            m.put(counts[nums[i]], m.getOrDefault(counts[nums[i]], 0) + 1);
            if (m.size() == 1 && (m.firstEntry().getKey() == 1 || m.firstEntry().getValue() == 1) ||
                    m.size() == 2 && (m.firstEntry().getKey() == 1 && m.firstEntry().getValue() == 1) ||
                    (m.lastEntry().getKey() == m.firstKey() + 1 && m.lastEntry().getValue() == 1)) {
                res = i + 1;
            }
        }
        return res;
    }


}
