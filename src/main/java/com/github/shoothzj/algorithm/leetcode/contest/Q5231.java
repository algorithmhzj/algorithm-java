package com.github.shoothzj.algorithm.leetcode.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q5231 {

    public List<String> removeSubfolders(String[] folder) {
        HzjNode rootNode = new HzjNode();
        for (String str: folder) {
            String[] split = str.split("/");
            HzjNode auxNode = rootNode;
            for (int i = 0; i < split.length; i++) {
                if (auxNode.map.containsKey(split[i])) {
                    auxNode = auxNode.map.get(split[i]);
                } else {
                    HzjNode hzjNode = new HzjNode();
                    hzjNode.path = "/" + split[i];
                    auxNode.map.put(split[i], hzjNode);
                    auxNode = hzjNode;
                }
                if (i == split.length - 1) {
                    auxNode.val = 1;
                }
            }
        }
        List<String> result = new ArrayList<>();
        dfs(result, rootNode, "");
        return result;
    }

    private void dfs(List<String> result, HzjNode node, String suffix) {
        String newSuffix = suffix + node.path;
        if (node.val == 1) {
            result.add(newSuffix.substring(1));
            return;
        }
        node.map.forEach((s, hzjNode) -> dfs(result, hzjNode, newSuffix));
    }

    static class HzjNode {
        String path = "";
        int val = 0;
        public final HashMap<String, HzjNode> map = new HashMap<>();

    }

}
