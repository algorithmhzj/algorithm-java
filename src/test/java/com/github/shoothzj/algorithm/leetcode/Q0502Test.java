package com.github.shoothzj.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q0502Test {

    private final Q0502 q0502 = new Q0502();

    @Test
    public void test() {
        int capital = q0502.findMaximizedCapital(1, 2, new int[]{1, 2, 3}, new int[]{1, 1, 2});
        Assertions.assertEquals(5, capital);
    }

}