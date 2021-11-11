package com.github.shoothzj.algorithm.leetcode.contest;

import com.github.shoothzj.algorithm.leetcode.LeetCodeUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

class Q5273Test {

    private final Q5273 q5273 = new Q5273();

    @Test
    public void test() {
        List<List<String>> list = q5273.suggestedProducts(LeetCodeUtil.convertToStringArray("[\"mobile\",\"mouse\",\"moneypot\",\"monitor\",\"mousepad\"]"), "mouse");
        System.out.println(list);
    }

}