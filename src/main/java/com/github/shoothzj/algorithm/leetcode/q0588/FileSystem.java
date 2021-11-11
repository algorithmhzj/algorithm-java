package com.github.shoothzj.algorithm.leetcode.q0588;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
class FileSystem {

    private final HashMap<String, TreeMap<String, String>> map = new HashMap<>();

    private final HashMap<String, String> contentMap = new HashMap<>();

    public FileSystem() {

    }

    public List<String> ls(String path) {
        List<String> result = new ArrayList<>();
        if (contentMap.containsKey(path)) {
            String substring = path.substring(path.lastIndexOf("/") + 1);
            result.add(substring);
            return result;
        }
        if (path.charAt(path.length() - 1) != '/') {
            path = path + "/";
        }
        TreeMap<String, String> treeMap = map.get(path);
        if (treeMap == null) {
            return result;
        }
        treeMap.forEach((s, s2) -> result.add(s));
        return result;
    }

    public void mkdir(String path) {
        process(path);
    }

    public void addContentToFile(String filePath, String content) {
        process(filePath);
        String s = contentMap.get(filePath);
        if (s == null) {
            contentMap.put(filePath, content);
        } else {
            contentMap.put(filePath, s + content);
        }
    }

    private void process(String path) {
        String[] split = path.split("/");
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < split.length - 1; i++) {
            String str = split[i];
            prefix.append("/");
            map.putIfAbsent(prefix.toString(), new TreeMap<>());
            TreeMap<String, String> treeMap = map.get(prefix.toString());
            treeMap.put(split[i + 1], split[i + 1]);
            prefix.append(split[i + 1]);
        }
    }

    public String readContentFromFile(String filePath) {
        return contentMap.get(filePath);
    }
}