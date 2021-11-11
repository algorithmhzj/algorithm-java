package com.github.shoothzj.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

class Q0320Test {

    private final Q0320 q0320 = new Q0320();

    @Test
    public void test() {
        List<String> word = q0320.generateAbbreviations("word");
        System.out.println(word);
    }

}