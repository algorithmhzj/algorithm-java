package com.github.shoothzj.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q0992TLE {

    public int subarraysWithKDistinct(int[] A, int K) {
        List<Set<Integer>> setList = new ArrayList<>();
        int result = 0;
        for (int k : A) {
            HashSet<Integer> hashSet = new HashSet<>();
            hashSet.add(k);
            setList.add(hashSet);
        }
        if (K == 1) {
            result += A.length;
        }
        for (int i = 1; i < A.length; i++) {
            List<Set<Integer>> newList = new ArrayList<>();
            for (int j = i; j < A.length; j++) {
                Set<Integer> integers = setList.get(j - i);
                Set<Integer> integers1 = setList.get(j - i + 1);
                if (integers == null || integers1 == null) {
                    newList.add(null);
                    continue;
                }
                integers.addAll(integers1);
                if (integers.size() > K) {
                    newList.add(null);
                    continue;
                }
                if (integers.size() == K) {
                    result++;
                }
                newList.add(integers);
            }
            setList = newList;
        }
        return result;
    }

}