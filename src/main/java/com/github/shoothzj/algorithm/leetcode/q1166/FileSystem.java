package com.github.shoothzj.algorithm.leetcode.q1166;

import java.util.HashMap;
import java.util.Map;

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */
class FileSystem {

    private final FileNode rootNode;

    public FileSystem() {
        rootNode = new FileNode("/", 0);
    }

    public boolean createPath(String path, int value) {
        String[] split = path.split("/");
        FileNode aux = rootNode;
        for (int i = 1; i < split.length - 1; i++) {
            aux = aux.children.get(split[i]);
            if (aux == null) {
                return false;
            }
        }
        String key = split[split.length - 1];
        if (aux.children.get(key) != null) {
            return false;
        }
        aux.children.put(key, new FileNode(key, value));
        return true;
    }

    public int get(String path) {
        String[] split = path.split("/");
        FileNode aux = rootNode;
        for (int i = 1; i < split.length - 1; i++) {
            aux = aux.children.get(split[i]);
            if (aux == null) {
                return -1;
            }
        }
        String key = split[split.length - 1];
        if (aux.children.get(key) == null) {
            return -1;
        }
        return aux.children.get(key).value;
    }

    class FileNode {
        String name;
        int value;
        Map<String, FileNode> children;

        public FileNode(String name, int value) {
            this.name = name;
            this.value = value;
            this.children = new HashMap<>();
        }
    }

}