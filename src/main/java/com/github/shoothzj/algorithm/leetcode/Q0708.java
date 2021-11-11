package com.github.shoothzj.algorithm.leetcode;

class Q0708 {

    /**
     * https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/discuss/343541/Java-simple-one-pass-solution-with-explanation
     * - if insertVal > cur.val, we want to append the new node after cur node, the node following cur node may still be smaller than the insertVal
     * - if insertVal < cur.val, we want to insert the new node before cur node, the node preceding cur node may still be greater than the insertVal
     * - if insertVal == cur.val, just append it after the cur node
     * However, the above strategy is not that easy to be implemented, we can use the following strategy:
     * - we only insert the new node into the next node of cur node if the insertVal is equal to the val of the cur node or insertVal is greater than the cur 's val and smaller than the cur.next 's val.
     * - Otherwise we can move to find the next node in the cycle which is smaller than the insertVal if there is any, and we append the node to the max node in the cycle.
     * @param head
     * @param insertVal
     * @return
     */
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            head = new Node(insertVal, head);
            head.next = head;
        } else {
            Node cur = head, max = null;
            while (max == null || cur != head) {
                if (insertVal == cur.val || cur.val < insertVal && cur.next.val > insertVal) {
                    cur.next = new Node(insertVal, cur.next);
                    return head;
                }
                if (max == null || cur.val >= max.val && cur.next.val < cur.val) { 
                    max = cur;                                                     
                }
                cur = cur.next;
            }
            max.next = new Node(insertVal, max.next);
        }
        return head;
    }
}