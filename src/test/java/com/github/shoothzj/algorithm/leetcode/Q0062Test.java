package com.github.shoothzj.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q0062Test {

    private final Q0062 q0062 = new Q0062();

    @Test
    public void test() {
        int res = q0062.uniquePaths(23, 12);
        Assertions.assertEquals(193536720, res);
    }

}