package com.github.shoothzj.algorithm.leetcode.q0642;

import org.junit.jupiter.api.Test;

class AutocompleteSystemTest {

    @Test
    public void testCase1() {
        AutocompleteSystem obj = new AutocompleteSystem(new String[]{"i love you", "island", "iroman", "i love leetcode"}, new int[]{5, 3, 2, 2});
        obj.input('i');
        obj.input(' ');
        obj.input('a');
        obj.input('#');
    }

}