package com.github.shoothzj.algorithm.leetcode.contest;

/**
 * @author hezhangjian
 */
public class Q5272 {

    public int countServers(int[][] grid) {
        int res = 0;
        int[] row = new int[grid.length];
        int[] col = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && (row[i] != 1 || col[j] != 1)) {
                    res ++;
                }
            }
        }
        return res;
    }

}
