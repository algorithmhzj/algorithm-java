package com.github.shoothzj.algorithm.amosdeke;

import java.util.Arrays;

public class Q0068 {

    public int minAbsAdd(int[] array) {
        Arrays.sort(array);
        // use two pointers
        int i = 0;
        int j = array.length - 1;
        int min = Integer.MAX_VALUE;
        while (i < j) {
            int sum = array[i] + array[j];
            min = Math.min(min, Math.abs(sum));
            if (sum > 0) {
                j--;
            } else {
                i++;
                if (i == array.length) {
                    break;
                }
            }
        }
        return min;
    }

}
