package com.github.shoothzj.algorithm.leetcode.contest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q5214Test {

    private final Q5214 q5214 = new Q5214();

    @Test
    public void test() {
        int i = q5214.longestSubsequence(new int[]{7, -2, 8, 10, 6, 18, 9, -8, -5, 18, 13, -6, -17, -1, -6, -9, 9, 9}, 1);
        Assertions.assertEquals(3, i);
    }

}