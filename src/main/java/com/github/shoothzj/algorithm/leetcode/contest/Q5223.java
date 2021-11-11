package com.github.shoothzj.algorithm.leetcode.contest;

import java.util.ArrayList;
import java.util.List;

public class Q5223 {

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> result = new ArrayList<>();
        int[][] board = new int[8][8];
        //queue to 1
        for (int[] queen : queens) {
            board[queen[0]][queen[1]] = 1;
        }
        //计算king的四个方向
        //左赋值
        int x = king[0] - 1;
        int y = king[1];
        while (x>=0) {
            if (board[x][y] == 1) {
                addToResult(result, x, y);
                break;
            }
            x--;
        }
        //右赋值
        x = king[0] + 1;
        while (x < 8) {
            if (board[x][y] == 1) {
                addToResult(result, x, y);
                break;
            }
            x++;
        }
        //上赋值
        x = king[0];
        y = king[1] - 1;
        while (y >= 0) {
            if (board[x][y] == 1) {
                addToResult(result, x, y);
                break;
            }
            y--;
        }
        //下赋值
        y = king[1] + 1;
        while (y < 8) {
            if (board[x][y] == 1) {
                addToResult(result, x, y);
                break;
            }
            y++;
        }
        //左上赋值
        x = king[0] - 1;
        y = king[1] - 1;
        while (x >=0 && y >= 0) {
            if (board[x][y] == 1) {
                addToResult(result, x, y);
                break;
            }
            x--;
            y--;
        }
        //右上赋值
        x = king[0] + 1;
        y = king[1] - 1;
        while (x < 8 && y >= 0) {
            if (board[x][y] == 1) {
                addToResult(result, x, y);
                break;
            }
            x++;
            y--;
        }
        //左下赋值
        x = king[0] - 1;
        y = king[1] + 1;
        while (x >=0 && y < 8) {
            if (board[x][y] == 1) {
                addToResult(result, x, y);
                break;
            }
            x--;
            y++;
        }
        //右下赋值
        x = king[0] + 1;
        y = king[1] + 1;
        while (x < 8 && y < 8) {
            if (board[x][y] == 1) {
                addToResult(result, x, y);
                break;
            }
            x++;
            y++;
        }
        return result;
    }

    private void addToResult(List<List<Integer>> result, int x, int y) {
        ArrayList<Integer> e = new ArrayList<>();
        e.add(x);
        e.add(y);
        result.add(e);
    }

}
