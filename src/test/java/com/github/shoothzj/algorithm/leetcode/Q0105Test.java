package com.github.shoothzj.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q0105Test {

    private final Q0105 q0105 = new Q0105();

    @Test
    public void testCase1() {
        TreeNode treeNode = q0105.buildTree(new int[]{1, 2, 3}, new int[]{2, 1, 3});
        Assertions.assertEquals(1, treeNode.val);
    }

    @Test
    public void testCase2() {
        TreeNode treeNode = q0105.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        Assertions.assertEquals(3, treeNode.val);
    }

}