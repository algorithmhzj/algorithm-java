package com.github.shoothzj.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q1698Test {

    private final Q1698 q1698 = new Q1698();

    @Test
    public void testCase1() {
        int res = q1698.countDistinct("aabbaba");
        Assertions.assertEquals(21, res);
    }

}