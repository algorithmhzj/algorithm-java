package com.github.shoothzj.algorithm.leetcode.contest;

import com.google.common.annotations.VisibleForTesting;

import java.util.ArrayList;
import java.util.List;

public class Q5175Failure {

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        for (int[] temp : queries) {
            result.add(canChange(s.substring(temp[0], temp[1] + 1), temp[2]));
        }
        return result;
    }

    @VisibleForTesting
    boolean canChange(String str, int footLen) {
        if (str.length() == 1) {
            return true;
        }
        int[] array = new int[26];
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            array[c - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += (array[i] % 2);
            if (count > 2* footLen) {
                return false;
            }
        }
        count /= 2;
        return footLen >= count;
    }

}
