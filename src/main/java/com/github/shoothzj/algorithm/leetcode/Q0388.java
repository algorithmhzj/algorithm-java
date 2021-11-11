package com.github.shoothzj.algorithm.leetcode;

public class Q0388 {


    public int lengthLongestPath(String input) {
        String[] strs = input.split("\\n");
        int max = 0;
        int[] arr = new int[strs.length];
        for (String str : strs) {
            int lv = 0;
            for (int i = 0; i < str.length(); i++)
                if (str.charAt(i) == '\t') lv++;
                else break;
            arr[lv] = lv == 0 ? str.length() : arr[lv - 1] + 1 + str.length() - lv;
            if (str.contains(".")) max = Math.max(arr[lv], max);
        }
        return max;
    }

}
