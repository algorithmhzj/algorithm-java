package com.github.shoothzj.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Q0106Test {

    private final Q0106 q0106 = new Q0106();

    @Test
    public void testCase1() {
        TreeNode treeNode = q0106.buildTree(new int[]{2, 1, 3}, new int[]{2, 3, 1});
        Assertions.assertEquals(1, treeNode.val);
    }

    @Test
    public void testCase2() {
        TreeNode treeNode = q0106.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        Assertions.assertEquals(3, treeNode.val);
    }

}