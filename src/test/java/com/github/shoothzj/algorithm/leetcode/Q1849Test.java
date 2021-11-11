package com.github.shoothzj.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q1849Test {

    final Q1849 q1849 = new Q1849();

    @Test
    public void testSplitStringCase1() {
        final boolean result = q1849.splitString("0090089");
        Assertions.assertTrue(result);
    }

    @Test
    public void testSplitStringCase2() {
        final boolean result = q1849.splitString("1234");
        Assertions.assertFalse(result);
    }

    @Test
    public void testSplitStringCase3() {
        final boolean result = q1849.splitString("050043");
        Assertions.assertTrue(result);
    }

    @Test
    public void testSplitStringCase4() {
        final boolean result = q1849.splitString("64424509442147483647");
        Assertions.assertFalse(result);
    }

    @Test
    public void testSplitStringCase5() {
        final boolean result = q1849.splitString("1");
        Assertions.assertFalse(result);
    }

}