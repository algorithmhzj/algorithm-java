package com.github.shoothzj.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q0250Test {

    private final Q0250 q0250 = new Q0250();

    @Test
    public void testCase1() {
        TreeNode root = LeetCodeUtil.constructTreeNode(new Integer[]{5, 1, 5, 5, 5, null, 5});
        int res = q0250.countUnivalSubtrees(root);
        Assertions.assertEquals(4, res);
    }

}