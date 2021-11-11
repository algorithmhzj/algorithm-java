package com.github.shoothzj.algorithm.leetcode.contest;

import org.junit.jupiter.api.Test;

class Q5173Test {

    private final Q5173 q5173 = new Q5173();

    @Test
    public void test() {
        // 1-1 2-1
        for (int i = 3; i <= 100; i++) {
            int i1 = q5173.numPrimeArrangements(i);
            System.out.println("i " + i + " " + i1 + ",");
        }
    }

}