package com.github.shoothzj.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q1858Test {

    private final Q1858 q1858 = new Q1858();

    @Test
    public void testCase1() {
        final String longestWord = q1858.longestWord(new String[]{"k", "ki", "kir", "kira", "kiran"});
        Assertions.assertEquals("kiran", longestWord);
    }

}