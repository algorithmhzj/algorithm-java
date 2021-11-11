package com.github.shoothzj.algorithm.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * @author hezhangjian
 */
public class Q1858 {

    public String longestWord(String[] words) {
        final Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word.toCharArray());
        }
        // bfs would do this work
        List<Aux> lastNodeList = new ArrayList<>();
        lastNodeList.add(new Aux(trie.getRoot()));
        while (true) {
            List<Aux> list = new ArrayList<>();
            for (Aux aux : lastNodeList) {
                final TrieNode[] children = aux.trieNode.children;
                for (TrieNode node : children) {
                    if (node == null || !node.isEndingChar) {
                        continue;
                    }
                    list.add(new Aux(node, aux.str + node.data));
                }
            }
            if (list.size() == 0) {
                break;
            }
            lastNodeList = list;
        }
        return lastNodeList.get(0).str;
    }

    static class Aux {
        TrieNode trieNode;
        String str;

        public Aux(TrieNode trieNode) {
            this.trieNode = trieNode;
            this.str = "";
        }

        public Aux(TrieNode trieNode, String str) {
            this.trieNode = trieNode;
            this.str = str;
        }
    }

}
