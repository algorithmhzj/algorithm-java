package com.github.shoothzj.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q0020Test {

    private final Q0020 q0020 = new Q0020();

    @Test
    public void test() {
        boolean valid = q0020.isValid("([)]");
        Assertions.assertFalse(valid);
    }

}