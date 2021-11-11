package com.github.shoothzj.algorithm.leetcode.contest;

public class Q5215 {

    private int m = 0;

    private int n = 0;

    private int res = 0;

    private int[][] visited;

    public int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, 0, grid);
            }
        }
        return res;
    }

    private void dfs(int i, int j, int val, int[][] grid) {
        if (grid[i][j] == 0) {
            return;
        }
        res = Math.max(res, val + grid[i][j]);
        visited[i][j] = 1;

        //top
        if (j - 1 >= 0 && visited[i][j - 1] != 1) {
            dfs(i, j - 1, val + grid[i][j], grid);
        }
        //left
        if (i - 1 >= 0 && visited[i - 1][j] != 1) {
            dfs(i - 1, j, val + grid[i][j], grid);
        }
        //right
        if (i + 1 < m && visited[i + 1][j] != 1) {
            dfs(i + 1, j, val + grid[i][j], grid);
        }
        //down
        if (j + 1 < n && visited[i][j + 1] != 1) {
            dfs(i, j + 1, val + grid[i][j], grid);
        }
        visited[i][j] = 0;
    }

}
