package com.github.shoothzj.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q0499Test {

    private final Q0499 q0499 = new Q0499();

    @Test
    public void test() {
        String shortestWay = q0499.findShortestWay(LeetCodeUtil.convertToTwoArray("[[0,1,0,0,1,0,0,1,0,0],[0,0,1,0,0,1,0,0,1,0],[0,0,0,0,0,0,1,0,0,1],[0,0,0,0,0,0,1,0,0,1],[0,1,0,0,1,0,0,1,0,0],[0,0,1,0,0,1,0,0,0,0],[0,0,0,0,0,0,1,0,0,0],[1,0,0,1,0,0,0,0,0,1],[0,1,0,0,1,0,0,1,0,0],[0,0,0,0,0,1,0,0,1,0]]"),
                new int[]{2, 4}, new int[]{7, 6});
        Assertions.assertEquals("drdrdrdldl", shortestWay);
    }

}