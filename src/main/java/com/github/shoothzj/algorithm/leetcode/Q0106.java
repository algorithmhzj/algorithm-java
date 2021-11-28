package com.github.shoothzj.algorithm.leetcode;

public class Q0106 {

    public TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        TreeNode node = new TreeNode(postorder[postEnd]);
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == postorder[postEnd]) {
                if (i > inStart) {
                    // proves exist leftNode
                    node.left = buildTree(inorder, postorder, inStart, i -1, postStart, postStart + i - 1 - inStart);
                }
                if (i < inEnd) {
                    // proves exist rightNode
                    node.right = buildTree(inorder, postorder, i + 1, inEnd, postStart + i - inStart, postEnd - 1);
                }
                break;
            }
        }
        return node;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

}
