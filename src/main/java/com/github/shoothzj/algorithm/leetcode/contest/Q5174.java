package com.github.shoothzj.algorithm.leetcode.contest;

public class Q5174 {

    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int result = 0;
        for (int index = 0; index < (calories.length - k + 1); index++) {
            int aux = 0;
            for (int i = index; i < index + k && i < calories.length; i++) {
                aux += calories[i];
            }
            if (aux > upper) {
                result += 1;
            } else if (aux < lower) {
                result -= 1;
            }
        }


        return result;
    }

}
