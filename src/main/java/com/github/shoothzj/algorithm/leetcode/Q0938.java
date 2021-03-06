package com.github.shoothzj.algorithm.leetcode;

public class Q0938 {

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }

        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        } else if (root.val == L) {
            return rangeSumBST(root.right, L, R) + root.val;
        } else if (root.val < R) {
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        } else if (root.val == R) {
            return root.val + rangeSumBST(root.left, L, R);
        } else {
            //root.val > R
            return rangeSumBST(root.left, L, R);
        }
    }

}
