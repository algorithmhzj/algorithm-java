package com.github.shoothzj.algorithm.leetcode.contest;

/**
 * @author hezhangjian
 */
public class Q5255 {

    public int oddCells(int n, int m, int[][] indices) {
        boolean[][] auxArray = new boolean[n][m];
        for (int[] index : indices) {
            int x = index[0];
            int y = index[1];

            for (int j = 0; j < m; j++) {
                auxArray[x][j] = !auxArray[x][j];
            }
            for (int j = 0; j < n; j++) {
                auxArray[j][y] = !auxArray[j][y];
            }
        }
        int count = 0;
        for (boolean[] booleans : auxArray) {
            for (int j = 0; j < auxArray[0].length; j++) {
                if (booleans[j]) {
                    count++;
                }
            }
        }
        return count;
    }

}
