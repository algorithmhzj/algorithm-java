package com.github.shoothzj.algorithm.leetcode;

/**
 * @author hezhangjian
 */
public class Q2046 {

    public ListNode sortLinkedList(ListNode node) {
        ListNode dummy = new ListNode(0);
        dummy.next = node;
        ListNode pre = node;
        ListNode cur = node.next;

        while (cur != null) {

            // 如果是负数移动到头节点
            if (cur.val < 0) {
                pre.next = cur.next;
                cur.next = dummy.next;
                dummy.next = cur;
                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }

        }
        return dummy.next;
    }

}
