package com.github.shoothzj.algorithm.leetcode;

import java.util.ArrayList;

/**
 * @author hezhangjian
 */
public class Q1065 {

    public int[][] indexPairs(String text, String[] words) {
        final Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word.toCharArray());
        }
        final ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            TrieNode node = trie.getRoot();
            for (int j = i; j < text.length(); j++) {
                node = node.children[text.charAt(j) - 'a'];
                if (node == null)
                    break;
                if (node.isEndingChar) {
                    list.add(new int[]{i, j});
                }
            }
        }
        return list.toArray(int[][]::new);
    }

}
