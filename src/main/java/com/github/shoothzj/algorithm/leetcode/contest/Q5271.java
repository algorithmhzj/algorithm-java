package com.github.shoothzj.algorithm.leetcode.contest;

/**
 * @author hezhangjian
 */
public class Q5271 {

    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int[] pointA = points[i];
            int[] pointB = points[i + 1];
            res += Math.max(Math.abs(pointB[0] - pointA[0]), Math.abs(pointB[1] - pointA[1]));
        }
        return res;
    }

}
