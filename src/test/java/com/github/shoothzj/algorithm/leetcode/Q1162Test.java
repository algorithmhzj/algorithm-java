package com.github.shoothzj.algorithm.leetcode;

import org.junit.jupiter.api.Test;

class Q1162Test {

    private final Q1162 q1162 = new Q1162();

    @Test
    public void test() {
        int[][] grid = new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        int i = q1162.maxDistance(grid);
    }

}