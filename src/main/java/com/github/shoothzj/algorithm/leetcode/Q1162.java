package com.github.shoothzj.algorithm.leetcode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。
 * <p>
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 * <p>
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/as-far-from-land-as-possible
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q1162 {

    static class Point {
        public final int x;
        public final int y;

        public Point(int x, int y) {
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

    public int maxDistance(int[][] grid) {
        //可以使用广度优先遍历
        Set<Point> processedSet = new HashSet<>();
        Set<Point> bfsList = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            int[] ints = grid[i];
            for (int j = 0; j < ints.length; j++) {
               if (grid[i][j] == 1) {
                   //this is land
                   Point p = new Point(i, j);
                   processedSet.add(p);
                   bfsList.add(p);
               }
            }
        }
        int happyCount = 0;
        while (true) {
            //根据bfsList开始bfs
            Set<Point> auxPoint = new HashSet<>();
            processedSet.addAll(bfsList);
            for (Point point : bfsList) {
                //计算每一个point的上下左右
                if (point.x != 0) {
                    //contains left
                    Point leftPoint = new Point(point.x - 1, point.y);
                    if (!processedSet.contains(leftPoint)) {
                        auxPoint.add(leftPoint);
                    }
                }
                if (point.x != (grid.length - 1)) {
                    //contains right
                    Point rightPoint = new Point(point.x + 1, point.y);
                    if (!processedSet.contains(rightPoint)) {
                        auxPoint.add(rightPoint);
                    }
                }
                if (point.y != 0) {
                    //contains up
                    Point upPoint = new Point(point.x, point.y - 1);
                    if (!processedSet.contains(upPoint)) {
                        auxPoint.add(upPoint);
                    }
                }
                if (point.y != (grid[0].length - 1)) {
                    //contains down
                    Point downPoint = new Point(point.x, point.y + 1);
                    if (!processedSet.contains(downPoint)) {
                        auxPoint.add(downPoint);
                    }
                }
            }
            if (auxPoint.size() == 0) {
                return happyCount == 0 ? -1 : happyCount;
            } else {
                happyCount++;
                bfsList = auxPoint;
            }
        }
    }

}
