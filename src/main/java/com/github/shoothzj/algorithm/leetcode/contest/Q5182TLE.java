package com.github.shoothzj.algorithm.leetcode.contest;

public class Q5182TLE {

    public int maximumSum(int[] arr) {
        int result = Integer.MIN_VALUE;
        int[] sumArray = new int[arr.length];
        int[] minArray = new int[arr.length];
        for (int i = 0; i < sumArray.length; i++) {
            sumArray[i] = arr[i];
            minArray[i] = arr[i];
            result = Math.max(result, arr[i]);
        }

        //开始DP
        for (int len = arr.length - 1; len > 0; len--) {
            int[] nextSumArray = new int[len];
            int[] nextMinArray = new int[len];
            for (int i = 0; i < len; i++) {
                nextSumArray[i] = sumArray[i] + arr[arr.length - len + i];
                nextMinArray[i] = Math.min(minArray[i], minArray[i + 1]);
                if (nextMinArray[i] < 0) {
                    result = Math.max(result, nextSumArray[i] - nextMinArray[i]);
                } else {
                    result = Math.max(result, nextSumArray[i]);
                }
            }
            sumArray = nextSumArray;
            minArray = nextMinArray;
        }

        return result;
    }

}
