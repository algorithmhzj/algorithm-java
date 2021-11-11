package com.github.shoothzj.algorithm.leetcode;

public class Q0062 {

    public int uniquePaths(int m, int n) {
        //memo  n means remaining
        int[][] memo = new int[m][n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += dfs(memo, 0, i);
        }
        return res;
    }

    private int dfs(int[][] memo, int current, int remaining) {
        if (current >= memo.length) {
            return 0;
        }
        if (memo[current][remaining] != 0) {
            return memo[current][remaining];
        }
        if (remaining == 0) {
            memo[current][remaining] = 1;
            return 1;
        } else {
            if (current == memo.length - 1) {
                return 0;
            }
            int res = 0;
            for (int i = 0; i <= remaining; i++) {
                res += dfs(memo, current + 1, i);
            }
            memo[current][remaining] = res;
            return res;
        }
    }
}
