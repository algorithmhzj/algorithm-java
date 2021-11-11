package com.github.shoothzj.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q0944Test {

    private final Q0944 q0944 = new Q0944();

    @Test
    public void test() {
        int i = q0944.minDeletionSize(LeetCodeUtil.convertToStringArray("[\"a\",\"b\"]"));
        Assertions.assertEquals(0, i);
    }

}