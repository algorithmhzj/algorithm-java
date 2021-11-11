package com.github.shoothzj.algorithm.leetcode.q0489;

public interface Robot {

    boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    void turnLeft();

    void turnRight();

    // Clean the current cell.
    void clean();

}
