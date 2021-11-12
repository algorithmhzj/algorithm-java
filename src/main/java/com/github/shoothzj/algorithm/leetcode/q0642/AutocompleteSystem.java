package com.github.shoothzj.algorithm.leetcode.q0642;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
class AutocompleteSystem {

    private static final int HOT_SENTENCES_LIMIT = 3;

    // keep track of the times a sentence has occurred
    Map<String, Integer> sentenceCounts;

    // keep track of prefix as inputs are keyed
    StringBuilder prefix;

    // the root of the Trie
    TrieNode root;

    // the current node, we keep track of this as inputs are keyed
    // and reset to root when we # is entered
    TrieNode curr;

    public AutocompleteSystem(String[] sentences, int[] times) {
        this.sentenceCounts = new HashMap<>();
        this.prefix = new StringBuilder();
        this.root = new TrieNode();
        this.curr = root;

        // insert each sentence and its count in the trie
        for (int i = 0; i < sentences.length; i++) {
            insert(sentences[i], times[i]);
        }
    }

    // inserts a sentence and its count in the trie
    private void insert(String sentence, int count) {
        sentenceCounts.put(sentence, sentenceCounts.getOrDefault(sentence, 0) + count);

        TrieNode node = root;
        for (char ch : sentence.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                TrieNode newNode = new TrieNode();
                node.children.put(ch, newNode);
            }

            node = node.children.get(ch);

            if (!node.hotSentences.contains(sentence)) {
                node.hotSentences.add(sentence);
            }

            // we need to sort irrespective of we added a sentence above or not,
            // because sentence count may have changed in the sentenceCounts map
            node.hotSentences.sort((a, b) -> {
                if (sentenceCounts.get(a) == sentenceCounts.get(b)) {
                    return a.compareTo(b);
                }
                return sentenceCounts.get(b) - sentenceCounts.get(a);
            });

            // trip the hot sentences to the required count
            if (node.hotSentences.size() > HOT_SENTENCES_LIMIT) {
                node.hotSentences.remove(node.hotSentences.size() - 1);
            }
        }
    }

    public List<String> input(char c) {
        List<String> result = new ArrayList<>();

        // end marker
        if (c == '#') {
            // insert with 1 count
            insert(prefix.toString(), 1);

            // reset root and prefix
            curr = root;
            prefix = new StringBuilder();
            return result;
        }

        prefix.append(c);

        if (curr != null) {
            curr = curr.children.get(c);
        }
        if (curr != null) {
            return curr.hotSentences;
        }

        // we've reached the end of the tree, return empty list
        return result;
    }
}

class TrieNode {

    // store the top hotSentences in the Trie
    List<String> hotSentences;
    Map<Character, TrieNode> children;

    public TrieNode() {
        hotSentences = new ArrayList<>();
        children = new HashMap<>();
    }
}