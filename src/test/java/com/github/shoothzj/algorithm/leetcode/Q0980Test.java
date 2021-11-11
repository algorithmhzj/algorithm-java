package com.github.shoothzj.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q0980Test {

    private final Q0980 q0980 = new Q0980();

    @Test
    public void debugTest() {
        int i = q0980.uniquePathsIII(LeetCodeUtil.convertToTwoArray("[[1,0,2]]"));
        Assertions.assertEquals(1, i);
    }

}