package com.github.shoothzj.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hezhangjian
 */
public class Q1698S2 {

    public int countDistinct(String s) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                final String substring = s.substring(i, j);
                set.add(substring);
            }
        }
        return set.size();
    }

}
