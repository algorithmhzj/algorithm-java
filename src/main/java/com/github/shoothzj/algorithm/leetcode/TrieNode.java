package com.github.shoothzj.algorithm.leetcode;

public class TrieNode {

    public final char data;

    public final TrieNode[] children;

    public boolean isEndingChar = false;

    public TrieNode(char data) {
        this.data = data;
        this.children = new TrieNode[26];
    }

}