package com.github.shoothzj.algorithm.leetcode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Q0490 {

    private final Set<Point> dfsSet = new HashSet<>();

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        dfs(new Point(start[0], start[1]), maze);
        return dfsSet.contains(new Point(destination[0], destination[1]));
    }

    private void dfs(Point startPoint, int[][] maze) {
        if (dfsSet.contains(startPoint)) {
            return;
        }
        dfsSet.add(startPoint);
        //up
        {
            int helpX = startPoint.x;
            int helpY = startPoint.y;
            while (true) {
                if (helpX > 0 && maze[helpX - 1][helpY] == 0) {
                    helpX--;
                } else {
                    //that is the end
                    dfs(new Point(helpX, helpY), maze);
                    break;
                }
            }
        }
        //down
        {
            int helpX = startPoint.x;
            int helpY = startPoint.y;
            while (true) {
                if (helpX < maze.length - 1 && maze[helpX + 1][helpY] == 0) {
                    helpX++;
                } else {
                    //that is the end
                    dfs(new Point(helpX, helpY), maze);
                    break;
                }
            }
        }

        //left
        {
            int helpX = startPoint.x;
            int helpY = startPoint.y;
            while (true) {
                if (helpY > 0 && maze[helpX][helpY - 1] == 0) {
                    helpY--;
                } else {
                    //that is the end
                    dfs(new Point(helpX, helpY), maze);
                    break;
                }
            }
        }
        //right
        {
            int helpX = startPoint.x;
            int helpY = startPoint.y;
            while (true) {
                if (helpY < maze[0].length - 1 && maze[helpX][helpY + 1] == 0) {
                    helpY++;
                } else {
                    //that is the end
                    dfs(new Point(helpX, helpY), maze);
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
