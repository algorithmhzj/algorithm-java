package com.github.shoothzj.algorithm.leetcode;

import java.util.PriorityQueue;
import java.util.TreeMap;

public class Q1086 {

    public int[][] highFive(int[][] items) {
        TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
        for (int[] item : items) {
            int index = item[0];
            int score = item[1];
            PriorityQueue<Integer> queue = map.get(index);
            if (queue == null) {
                queue = new PriorityQueue<>(5, (o1, o2) -> o2 - o1);
            }
            queue.add(score);
            map.put(index, queue);
        }
        int[][] result = new int[map.size()][2];
        for (int i = 1; i <= result.length; i++) {
            PriorityQueue<Integer> queue = map.get(i);
            result[i - 1] = new int[]{i, getAve(queue)};
        }
        return result;
    }

    private int getAve(PriorityQueue<Integer> queue) {
        int count = 5;
        int sum = 0;
        while (count > 0) {
            Integer poll = queue.poll();
            sum += poll;
            count--;
        }
        return sum / 5;
    }

}
