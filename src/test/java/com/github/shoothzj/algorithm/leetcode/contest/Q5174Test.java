package com.github.shoothzj.algorithm.leetcode.contest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q5174Test {

    private final Q5174 q5174 = new Q5174();

    @Test
    public void test() {
        int res = q5174.dietPlanPerformance(new int[]{6, 13, 8, 7, 10, 1, 12, 11}, 6, 5, 37);
        Assertions.assertEquals(3, res);
    }

}