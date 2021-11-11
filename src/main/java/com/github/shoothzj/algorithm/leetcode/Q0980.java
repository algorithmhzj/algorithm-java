package com.github.shoothzj.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

//todo 问题转换为哈密顿图问题
public class Q0980 {

    private int m = 0;

    private int n = 0;

    public int uniquePathsIII(int[][] grid) {
        int startX = 0;
        int startY = 0;
        m = grid.length;
        n = grid[0].length;
        int rest = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 0) {
                    rest++;
                }
            }
        }
        return dfs(startX, startY, new HashSet<>(), grid, rest);
    }

    private int dfs(int nowX, int nowY, Set<String> walked, int[][] grid, int rest) {
        int result = 0;
        //站立在nowX,nowY
        //上
        {
            String aux = getAux(nowX, nowY - 1);
            if (nowY > 0 && !walked.contains(aux)) {
                if (rest == 0) {
                    if (grid[nowX][nowY - 1] == 2) {
                        result++;
                    }
                } else if (grid[nowX][nowY - 1] == 0) {
                    walked.add(aux);
                    result += dfs(nowX, nowY - 1, walked, grid, rest - 1);
                    walked.remove(aux);
                }
            }
        }
        //下
        {
            String aux = getAux(nowX, nowY + 1);
            if (nowY + 1 < n && !walked.contains(aux)) {
                if (rest == 0) {
                    if (grid[nowX][nowY + 1] == 2) {
                        result++;
                    }
                } else if (grid[nowX][nowY + 1] == 0) {
                    walked.add(aux);
                    result += dfs(nowX, nowY + 1, walked, grid, rest - 1);
                    walked.remove(aux);
                }
            }
        }
        //左
        {
            String aux = getAux(nowX - 1, nowY);
            if (nowX > 0 && !walked.contains(aux)) {
                if (rest == 0) {
                    if (grid[nowX - 1][nowY] == 2) {
                        result++;
                    }
                } else if (grid[nowX - 1][nowY] == 0) {
                    walked.add(aux);
                    result += dfs(nowX - 1, nowY, walked, grid, rest - 1);
                    walked.remove(aux);
                }
            }
        }
        //右
        {
            String aux = getAux(nowX + 1, nowY);
            if (nowX + 1 < m && !walked.contains(aux)) {
                if (rest == 0) {
                    if (grid[nowX + 1][nowY] == 2) {
                        result++;
                    }
                } else if (grid[nowX + 1][nowY] == 0) {
                    walked.add(aux);
                    result += dfs(nowX + 1, nowY, walked, grid, rest - 1);
                    walked.remove(aux);
                }
            }
        }
        return result;
    }

    private String getAux(int x, int y) {
        return x + "," + y;
    }

}
