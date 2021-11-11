package com.github.shoothzj.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q0213Test {

    private final Q0213 q0213 = new Q0213();

    @Test
    public void testCase1() {
        int res = q0213.rob(new int[]{1, 2, 3, 1});
        Assertions.assertEquals(4, res);
    }

}