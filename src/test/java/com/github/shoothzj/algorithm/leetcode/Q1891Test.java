package com.github.shoothzj.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q1891Test {

    private final Q1891 q1891 = new Q1891();

    @Test
    public void testCase1() {
        final int maxLength = q1891.maxLength(new int[]{9, 7, 5}, 3);
        Assertions.assertEquals(5, maxLength);
    }

    @Test
    public void testCase2() {
        final int maxLength = q1891.maxLength(new int[]{100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 1, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000}, 49);
        Assertions.assertEquals(100000, maxLength);
    }

}