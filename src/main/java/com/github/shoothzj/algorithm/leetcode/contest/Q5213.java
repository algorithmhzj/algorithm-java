package com.github.shoothzj.algorithm.leetcode.contest;

public class Q5213 {

    public int minCostToMoveChips(int[] chips) {
        int even = 0;
        int odd = 0;
        for (int i : chips) {
            if (i%2 == 1) {
                odd++;
            } else {
                even++;
            }
        }
        return Math.min(even, odd);
    }

}
