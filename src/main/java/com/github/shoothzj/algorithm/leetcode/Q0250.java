package com.github.shoothzj.algorithm.leetcode;

public class Q0250 {

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        DfsAux dfsAux = dfs(root);
        return dfsAux.curr;
    }

    private DfsAux dfs(TreeNode node) {
        if (node.left == null && node.right == null) {
            return new DfsAux(true, 1);
        }
        boolean unival = true;
        int val = 0;
        if (node.left != null) {
            DfsAux aux = dfs(node.left);
            val += aux.curr;
            unival = aux.uni && node.left.val == node.val;
        }
        if (node.right != null) {
            DfsAux aux = dfs(node.right);
            val += aux.curr;
            unival = unival && aux.uni && node.right.val == node.val;
        }
        if (unival) {
            return new DfsAux(true, val + 1);
        } else {
            return new DfsAux(false, val);
        }
    }

    static class DfsAux {
        private final boolean uni;
        private final int curr;

        public DfsAux(boolean uni, int curr) {
            this.uni = uni;
            this.curr = curr;
        }
    }

}
