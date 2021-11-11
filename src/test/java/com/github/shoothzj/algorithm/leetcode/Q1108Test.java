package com.github.shoothzj.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q1108Test {

    private final Q1108 q1108 = new Q1108();

    @Test
    public void test() {
        String result = q1108.defangIPaddr("255.100.50.0");
        assertEquals("255[.]100[.]50[.]0", result);
    }

}