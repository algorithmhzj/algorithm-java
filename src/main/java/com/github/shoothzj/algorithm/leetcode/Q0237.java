package com.github.shoothzj.algorithm.leetcode;

public class Q0237 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
