package com.github.shoothzj.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q0162Test {

    private final Q0162 q0162 = new Q0162();

    @Test
    public void doIt() {
        int[] array = new int[]{1, 2, 3, 1};
        int res = q0162.findPeakElement(array);
        Assertions.assertEquals(2, res);
    }

}