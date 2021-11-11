package com.github.shoothzj.algorithm.leetcode.contest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hezhangjian
 */
public class Q5256 {

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int twoCount = 0;
        int oneCount = 0;
        for (int j : colsum) {
            if (j == 2) {
                twoCount++;
            } else if (j == 1) {
                oneCount++;
            }
        }
        if (upper < twoCount) {
            return new ArrayList<>();
        }
        if (lower < twoCount) {
            return new ArrayList<>();
        }
        if ((2 * twoCount + oneCount) != (upper + lower)) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> upperList = new ArrayList<>();
        List<Integer> lowerList = new ArrayList<>();
        result.add(upperList);
        result.add(lowerList);
        int aux = upper - twoCount;
        for (int j : colsum) {
            if (j == 2) {
                upperList.add(1);
                lowerList.add(1);
            } else if (j == 0) {
                upperList.add(0);
                lowerList.add(0);
            } else {
                if (aux > 0) {
                    upperList.add(1);
                    lowerList.add(0);
                    aux--;
                } else {
                    upperList.add(0);
                    lowerList.add(1);
                }
            }
        }

        return result;
    }

}
