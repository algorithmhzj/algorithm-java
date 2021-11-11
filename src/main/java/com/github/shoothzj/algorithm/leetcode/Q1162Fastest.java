package com.github.shoothzj.algorithm.leetcode;

/**
 * @see Q1162
 */
public class Q1162Fastest {

    public int maxDistance(int[][] grid) {
        int N = grid.length;
        int SUM = N * N;
        int land = 0;
        int term = 1;

        while (land < SUM) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] == term) {
                        land += 1;
                        //up
                        if (i - 1 >= 0 && grid[i - 1][j] == 0) {
                            grid[i - 1][j] = term + 1;
                        }
                        //down
                        if (i + 1 < N && grid[i + 1][j] == 0) {
                            grid[i + 1][j] = term + 1;
                        }
                        //left
                        if (j - 1 >= 0 && grid[i][j - 1] == 0) {
                            grid[i][j - 1] = term + 1;
                        }
                        //right
                        if (j + 1 < N && grid[i][j + 1] == 0) {
                            grid[i][j + 1] = term + 1;
                        }
                    }
                }
            }
            if (term == 1 && (land == 0 || land == SUM)) {
                return -1;
            }
            term += 1;
        }
        return term - 2;
    }

}
