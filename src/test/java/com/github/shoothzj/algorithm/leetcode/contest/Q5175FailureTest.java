package com.github.shoothzj.algorithm.leetcode.contest;

import org.junit.jupiter.api.Test;

class Q5175FailureTest {

    private final Q5175Failure q5175 = new Q5175Failure();

    @Test
    public void test() {
        String substring = "hunu".substring(0, 4);
        q5175.canChange(substring, 1);
    }

}