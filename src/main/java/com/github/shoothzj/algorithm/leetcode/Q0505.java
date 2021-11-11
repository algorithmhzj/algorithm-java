package com.github.shoothzj.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Q0505 {

    /**
     * 维护dfs搜索的结果
     */
    private final Map<Point, Integer> dfsMap = new HashMap<>();

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        dfs(new Point(start[0], start[1]), maze, 0);
        Integer integer = dfsMap.get(new Point(destination[0], destination[1]));
        return integer == null ? -1 : integer;
    }

    private void dfs(Point startPoint, int[][] maze, int distance) {
        if (dfsMap.containsKey(startPoint)) {
            Integer integer = dfsMap.get(startPoint);
            //计算旧值,如果旧值小于当前值,那么需要刷新,根据上一跳的关联关系刷新
            if (distance < integer) {

            } else {
                return;
            }
        }
        dfsMap.put(startPoint, distance);
        //up
        {
            int aux = 0;
            int helpX = startPoint.x;
            int helpY = startPoint.y;
            while (true) {
                if (helpX > 0 && maze[helpX - 1][helpY] == 0) {
                    helpX--;
                    aux++;
                } else {
                    //that is the end
                    dfs(new Point(helpX, helpY), maze, distance + aux);
                    break;
                }
            }
        }
        //down
        {
            int aux = 0;
            int helpX = startPoint.x;
            int helpY = startPoint.y;
            while (true) {
                if (helpX < maze.length - 1 && maze[helpX + 1][helpY] == 0) {
                    helpX++;
                    aux++;
                } else {
                    //that is the end
                    dfs(new Point(helpX, helpY), maze, distance + aux);
                    break;
                }
            }
        }

        //left
        {
            int aux = 0;
            int helpX = startPoint.x;
            int helpY = startPoint.y;
            while (true) {
                if (helpY > 0 && maze[helpX][helpY - 1] == 0) {
                    helpY--;
                    aux++;
                } else {
                    //that is the end
                    dfs(new Point(helpX, helpY), maze, distance + aux);
                    break;
                }
            }
        }
        //right
        {
            int aux = 0;
            int helpX = startPoint.x;
            int helpY = startPoint.y;
            while (true) {
                if (helpY < maze[0].length - 1 && maze[helpX][helpY + 1] == 0) {
                    helpY++;
                    aux++;
                } else {
                    //that is the end
                    dfs(new Point(helpX, helpY), maze, distance + aux);
                    break;
                }
            }
        }
    }


    static class Point {
        final int x;
        final int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
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
