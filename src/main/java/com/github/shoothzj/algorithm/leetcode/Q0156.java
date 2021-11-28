package com.github.shoothzj.algorithm.leetcode;

public class Q0156 {

    /**
     * The original left child becomes the new root.
     * The original root becomes the new right child.
     * The original right child becomes the new left child.
     *
     * @param root
     * @return
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (null == root) {
            return null;
        }

        TreeNode prev = null;
        TreeNode currNode = root;
        TreeNode nextNode;
        TreeNode lastRight = null;

        // only need process left node
        while (null != currNode) {
            nextNode = currNode.left;
            currNode.left = lastRight;
            lastRight = currNode.right;
            currNode.right = prev;
            prev = currNode;
            currNode = nextNode;
        }

        return prev;
    }

}
