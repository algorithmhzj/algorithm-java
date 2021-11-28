package com.github.shoothzj.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCodeUtil {

    /**
     * [[0,11,0,0],[0,1,0,0],[0,0,0,0],[0,0,1,0],[0,0,0,0]]
     * @param src
     * @return
     */
    public static int[][] convertToTwoArray(String src) {
        src = src.trim();
        String[] split = src.split("],");
        int n = split[0].split(",").length;

        char[] array = src.toCharArray();
        StringBuilder aux = new StringBuilder();
        for (char ch: array) {
            if (ch == '[' || ch == ']') {
                continue;
            }
            aux.append(ch);
        }
        String[] splitArray = aux.toString().split(",");
        int total = splitArray.length;
        int m = total / n;

        int[][] res = new int[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = Integer.parseInt(splitArray[count++]);
            }
        }

        return res;
    }

    public static int[] convertToIntArray(String src) {
        src = src.trim();
        String aux = src.substring(1, src.length() - 1);
        String[] split = aux.split(",");
        int[] result = new int[split.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(split[i]);
        }
        return result;
    }

    public static String[] convertToStringArray(String src) {
        src = src.trim();
        String aux = src.substring(1, src.length() - 1);
        String[] split = aux.split(",");
        String[] result = new String[split.length];
        for (int i = 0; i < split.length; i++) {
            result[i] = split[i].substring(1, split[i].length() - 1);
        }
        return result;
    }

    /**
     * input 199
     * output 1->9->9
     * @return
     */
    public static ListNode constructListNode(String str) {
        char[] array = str.toCharArray();
        ListNode tail = new ListNode(array[array.length - 1] - '0');
        for (int i = array.length - 2; i >= 0; i--) {
            ListNode aux = new ListNode(array[i] - '0');
            aux.next = tail;
            tail = aux;
        }
        return tail;
    }

    public static TreeNode constructTreeNode(Integer[] integers) {
        TreeNode root = new TreeNode(integers[0]);
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(root);
        constructTreeNode(list, integers, 1);
        return root;
    }

    private static void constructTreeNode(List<TreeNode> treeNodes, Integer[] integers, int index) {
        if (index == integers.length) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        for (int i = 0; i < treeNodes.size(); i++) {
            TreeNode treeNode = treeNodes.get(i);
            if (treeNode == null) {
                list.add(null);
                list.add(null);
                continue;
            }
            TreeNode leftNode = integer2TreeNode(integers[index + 2 * i]);
            TreeNode rightNode = integer2TreeNode(integers[index + 2 * i + 1]);
            treeNode.left = leftNode;
            treeNode.right = rightNode;
            list.add(leftNode);
            list.add(rightNode);
        }
        constructTreeNode(list, integers, index + treeNodes.size() * 2);
    }

    private static TreeNode integer2TreeNode(Integer integer) {
        if (integer == null) {
            return null;
        }
        return new TreeNode(integer);
    }

}
