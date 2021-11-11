package com.github.shoothzj.algorithm.leetcode.contest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author hezhangjian
 */
public class Q5257 {

    private final List<Set<Point>> unionSetList = new ArrayList<>();
    private final Set<Point> processed = new HashSet<>();

    public int closedIsland(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                if (processed.contains(new Point(i, j))) {
                    continue;
                }
                //island
                if (grid[i][j] == 0) {
                    Set<Point> pointSet = new HashSet<>();
                    dfs(grid, pointSet, i, j);
                    unionSetList.add(pointSet);
                }
            }
        }
        int res = 0;
        for (Set<Point> pointSet: unionSetList) {
            boolean flag = true;
            for (Point point: pointSet) {
                if (pointInBoard(point, grid)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res += 1;
            }
        }
        return res;
    }

    private boolean pointInBoard(Point point, int[][] grid) {
        return point.x == 0 || point.x == grid.length - 1 || point.y == 0 || point.y == grid[0].length - 1;
    }

    private void dfs(int[][] grid, Set<Point> pointSet, int x, int y) {
        if (x < 0 || x >= grid.length) {
            return;
        }
        if (y < 0 || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] == 1) {
            return;
        }
        if (processed.contains(new Point(x, y))) {
            return;
        }
        processed.add(new Point(x, y));
        pointSet.add(new Point(x, y));
        dfs(grid, pointSet, x -1, y);
        dfs(grid, pointSet, x + 1, y);
        dfs(grid, pointSet, x, y -1 );
        dfs(grid, pointSet, x, y + 1);
    }

    static class Point {
        final int x;
        final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
