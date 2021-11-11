package com.github.shoothzj.algorithm.leetcode;

public class Q0002 {

    /**
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     * Example:
     *
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int i = l1.val + l2.val;
        ListNode result = new ListNode(i%10);
        int aux = i/10;
        l1 = l1.next;
        l2 = l2.next;
        ListNode auxNode = result;
        while (aux != 0 || l2 != null || l1 != null) {
            int temp = aux;
            if (l2 != null) {
                temp += l2.val;
                l2 = l2.next;
            }
            if (l1 != null) {
                temp += l1.val;
                l1 = l1.next;
            }
            auxNode.next = new ListNode(temp%10);
            auxNode = auxNode.next;
            aux = temp/10;
        }

        return result;
    }


}
