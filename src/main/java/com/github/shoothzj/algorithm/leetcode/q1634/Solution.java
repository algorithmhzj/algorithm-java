package com.github.shoothzj.algorithm.leetcode.q1634;

class Solution {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        final PolyNode dummy = new PolyNode();
        PolyNode cur = dummy;
        while (poly1 != null || poly2 != null) {
            int e1 = poly1 == null ? -1 : poly1.power;
            int e2 = poly2 == null ? -1 : poly2.power;
            if (e1 > e2) {
                cur.next = new PolyNode(poly1.coefficient, poly1.power);
                poly1 = poly1.next;
                cur = cur.next;
            } else if (e1 < e2) {
                cur.next = new PolyNode(poly2.coefficient, poly2.power);
                poly2 = poly2.next;
                cur = cur.next;
            } else {
                if (poly1.coefficient + poly2.coefficient != 0) {
                    cur.next = new PolyNode(poly1.coefficient + poly2.coefficient, poly1.power);
                    cur = cur.next;
                }
                poly1 = poly1.next;
                poly2 = poly2.next;
            }
        }
        return dummy.next;
    }
}