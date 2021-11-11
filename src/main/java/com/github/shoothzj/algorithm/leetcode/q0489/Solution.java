package com.github.shoothzj.algorithm.leetcode.q0489;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Solution {

    /**
     * going clockwise 0: 'up', 1: 'right',2: 'down',3: 'left'
     */
    final int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    final Set<Pair<Integer, Integer>> visited = new HashSet<>();

    Robot robot;

    public void cleanRoom(Robot robot) {
        //执行策略,一圈一圈打扫
        this.robot = robot;
        backtrack(0, 0, 0);
    }

    void backtrack(int row, int col, int d) {
        visited.add(new Pair<>(row, col));
        robot.clean();
        // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
        for (int i = 0; i < 4; ++i) {
            int newD = (d + i) % 4;
            int newRow = row + directions[newD][0];
            int newCol = col + directions[newD][1];

            if (!visited.contains(new Pair<>(newRow, newCol)) && robot.move()) {
                backtrack(newRow, newCol, newD);
                goBack();
            }
            // turn the robot following chosen direction : clockwise
            robot.turnRight();
        }

    }

    void goBack() {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnLeft();
        robot.turnLeft();
    }

    static class Pair<F, S> {
        final F first;
        final S second;

        Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        @SuppressWarnings({"unchecked"})
        @Override
        public boolean equals(Object o) {
            Pair<F, S> p = (Pair<F, S>) o;
            return Objects.equals(p.first, first) && Objects.equals(p.second, second);
        }

        @Override
        public int hashCode() {
            return first.hashCode() ^ second.hashCode();
        }

    }

}