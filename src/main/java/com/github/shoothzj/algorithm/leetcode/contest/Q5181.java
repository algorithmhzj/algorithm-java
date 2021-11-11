package com.github.shoothzj.algorithm.leetcode.contest;

public class Q5181 {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int clockWise = 0;
        int antiClockWise = 0;
        int compareDown;
        int compareUp;
        if (start < destination) {
            compareDown = start;
            compareUp = destination;
        } else {
            compareDown = destination;
            compareUp = start;
        }

        for (int i = 0; i < distance.length; i++) {
            if ((i >= compareDown) && (i < compareUp)) {
                clockWise += distance[i];
            } else {
                antiClockWise += distance[i];
            }
        }

        return Math.min(clockWise, antiClockWise);
    }

}
