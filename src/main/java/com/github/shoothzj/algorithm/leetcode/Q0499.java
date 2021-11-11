package com.github.shoothzj.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class Q0499 {

    private static final int[][] dirs = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};

    private static final String[] routeArray = {"d", "l", "r", "u"};

    /**
     * 维护dfs搜索的结果
     */
    private final Map<Point, Integer> dfsMap = new HashMap<>();

    private final PriorityQueue<String> result = new PriorityQueue<>();

    private final Map<String, Integer> debugResult = new HashMap<>();

    private int MIN_VALUE = Integer.MAX_VALUE;

    public String findShortestWay(int[][] maze, int[] start, int[] destination) {
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return "";
        }
        dfs(new Point(start[0], start[1]), maze, 0, destination, "");
        String poll = result.poll();
        return poll == null ? "impossible" : poll;
    }

    private void dfs(Point startPoint, int[][] maze, int distance, int[] destination, String route) {
        if (dfsMap.containsKey(startPoint)) {
            Integer integer = dfsMap.get(startPoint);
            //计算旧值,如果旧值小于当前值,那么需要刷新
            if (distance >= integer) {
                return;
            }
        }
        dfsMap.put(startPoint, distance);
        for (int i = 0; i < 4; i++) {
            int aux = 0;
            int helpX = startPoint.x;
            int helpY = startPoint.y;
            while (true) {
                int aux1 = distance + aux;
                String aux2 = route + routeArray[i];
                if (destination[0] == helpX && destination[1] == helpY) {
                    debugResult.put(aux2, aux1);
                    if (aux1 > MIN_VALUE) {
                        return;
                    }
                    if (aux1 != MIN_VALUE) {
                        MIN_VALUE = aux1;
                        result.clear();
                    }
                    result.add(aux2);
                    return;
                }
                if ((helpX + dirs[i][0]) >= 0 && (helpX + dirs[i][0]) < maze.length && (helpY + dirs[i][1]) >= 0 && (helpY + dirs[i][1]) < maze[0].length
                        && maze[helpX + dirs[i][0]][helpY + dirs[i][1]] == 0) {
                    helpX += dirs[i][0];
                    helpY += dirs[i][1];
                    aux++;
                } else {
                    //that is the end
                    dfs(new Point(helpX, helpY), maze, aux1, destination, aux2);
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
