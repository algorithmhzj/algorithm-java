package com.github.shoothzj.algorithm.leetcode.contest;

import com.github.shoothzj.algorithm.leetcode.LeetCodeUtil;
import org.junit.jupiter.api.Test;

class Q5224Test {

    private final Q5224 q5224 = new Q5224();

    @Test
    public void test() {
        q5224.dieSimulator(2, LeetCodeUtil.convertToIntArray("[1,1,2,2,2,3]"));
    }

}