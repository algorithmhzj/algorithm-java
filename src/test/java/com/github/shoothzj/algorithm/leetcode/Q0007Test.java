package com.github.shoothzj.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q0007Test {

    private final Q0007 q0007 = new Q0007();

    @Test
    public void test01() {
        int reverse = q0007.reverse(-123);
        assertEquals(-321, reverse);
    }

    @Test
    public void test02() {
        int reverse = q0007.reverse(123);
        assertEquals(321, reverse);
    }

    @Test
    public void test03() {
        int reverse = q0007.reverse(1200);
        assertEquals(21, reverse);
    }

}