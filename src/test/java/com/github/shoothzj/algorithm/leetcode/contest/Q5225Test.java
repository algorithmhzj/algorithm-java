package com.github.shoothzj.algorithm.leetcode.contest;

import com.github.shoothzj.algorithm.leetcode.LeetCodeUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q5225Test {

    private final Q5225 q5225 = new Q5225();

    @Test
    public void test() {
        int res = q5225.maxEqualFreq(LeetCodeUtil.convertToIntArray("[1,1]"));
        Assertions.assertEquals(2, res);
    }

}