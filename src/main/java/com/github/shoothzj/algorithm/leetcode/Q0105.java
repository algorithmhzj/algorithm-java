package com.github.shoothzj.algorithm.leetcode;

public class Q0105 {

    public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        TreeNode node = new TreeNode(preorder[preStart]);
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                if (i > inStart) {
                    // proves exist leftNode
                    node.left = buildTree(preorder, inorder, preStart + 1, inStart, i - 1);
                }
                if (i < inEnd) {
                    // proves exist rightNode
                    node.right = buildTree(preorder, inorder, preStart + i - inStart + 1, i + 1, inEnd);
                }
                break;
            }
        }
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, 0, inorder.length - 1);
    }

}
