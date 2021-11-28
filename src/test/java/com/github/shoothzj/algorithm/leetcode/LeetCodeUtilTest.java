package com.github.shoothzj.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LeetCodeUtilTest {

    @Test
    public void testConvertToStringArray() {
        final String[] stringArray = LeetCodeUtil.convertToStringArray("[\"a\",\"b\"]");
        Assertions.assertEquals(2, stringArray.length);
    }

    @Test
    public void testConstructListNode() {
        ListNode listNode = LeetCodeUtil.constructListNode("199");
        Assertions.assertEquals(1, listNode.val);
        listNode = listNode.next;
        Assertions.assertEquals(9, listNode.val);
        listNode = listNode.next;
        Assertions.assertEquals(9, listNode.val);
    }

    @Test
    public void testConstructTreeNode() {
        TreeNode rootNode = LeetCodeUtil.constructTreeNode(new Integer[]{5, 1, 5, 5, 5, null, 5});
        Assertions.assertEquals(5, rootNode.val);
    }

}