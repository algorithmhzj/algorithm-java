package com.github.shoothzj.algorithm.leetcode.contest;

import com.github.shoothzj.algorithm.leetcode.LeetCodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q5257Test {

    private final Q5257 q5257 = new Q5257();

    @Test
    public void test() {
        int i = q5257.closedIsland(LeetCodeUtil.convertToTwoArray("[[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]"));
        Assertions.assertEquals(2, i);
    }

}