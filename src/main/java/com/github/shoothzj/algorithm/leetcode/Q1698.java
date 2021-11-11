package com.github.shoothzj.algorithm.leetcode;

/**
 * @author shoothzj
 */
public class Q1698 {

    public int countDistinct(String s) {
        Trie trie = new Trie();
        for (int i = 0; i < s.length(); i++) {
            trie.insert(s.substring(i).toCharArray());
        }
        return sum(trie.getRoot());
    }

    public int sum(TrieNode trieNode) {
        int res = 0;
        for (TrieNode child : trieNode.children) {
            if (child == null) {
                continue;
            }
            res += 1;
            res += sum(child);
        }
        return res;
    }

}
