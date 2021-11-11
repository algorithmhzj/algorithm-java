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
        Assertions.assertEquals(listNode.val, 1);
        listNode = listNode.next;
        Assertions.assertEquals(listNode.val, 9);
        listNode = listNode.next;
        Assertions.assertEquals(listNode.val, 9);
    }

}