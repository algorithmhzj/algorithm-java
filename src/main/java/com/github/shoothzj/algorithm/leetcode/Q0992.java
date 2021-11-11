package com.github.shoothzj.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q0992 {

    //it's base on a formula
    //if [i,lj] fulfill requirements, and also [i,rj] fulfill requirements
    //and a part of result, which also rj - lj
    public int subarraysWithKDistinct(int[] A, int K) {
        Window window1 = new Window();
        Window window2 = new Window();
        int ans = 0, left1 = 0, left2 = 0;

        for (int x : A) {
            window1.add(x);
            window2.add(x);

            while (window1.different() > K)
                window1.remove(A[left1++]);
            while (window2.different() >= K)
                window2.remove(A[left2++]);

            ans += left2 - left1;
        }

        return ans;
    }

    static class Window {
        final Map<Integer, Integer> count;
        int nonzero;

        Window() {
            count = new HashMap<>();
            nonzero = 0;
        }

        void add(int x) {
            boolean contains = count.containsKey(x);
            if (contains) {
                Integer integer = count.get(x);
                if (integer == 0) {
                    nonzero++;
                }
                count.put(x, integer + 1);
            } else {
                count.put(x, 1);
                nonzero++;
            }
        }

        void remove(int x) {
            Integer integer = count.get(x);
            count.put(x, integer - 1);
            if (integer == 1) {
                nonzero--;
            }
        }

        int different() {
            return nonzero;
        }

    }

}
