package com.github.shoothzj.algorithm.leetcode;

import org.junit.jupiter.api.Test;

class Q1137Test {

    private final Q1137 q1137 = new Q1137();

    @Test
    public void t() {
        System.out.print("{");
        for (int i = 0; i < 38; i++) {
            System.out.print(q1137.tribonacciSrc(i));
            System.out.print(",");
        }
        System.out.print("}");
    }

}