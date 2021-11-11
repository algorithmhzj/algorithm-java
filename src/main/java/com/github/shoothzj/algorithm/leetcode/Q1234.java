package com.github.shoothzj.algorithm.leetcode;

public class Q1234 {

    /**
     * https://leetcode.com/problems/replace-the-substring-for-balanced-string/discuss/409017/JAVA-Sliding-Window-Solution-with-Explanation
     */
    public int balancedString(String s) {
        // step 1, find freq of each first
        int N = s.length();
        int required = N / 4;

        int[] freq = new int[4];
        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            freq[char2Idx(c)]++;
        }

        // step 2 Determine the ones we need to change
        boolean equal = true;
        for (int i = 0; i < 4; ++i) {
            if (freq[i] != required) {
                equal = false;
            }
            freq[i] = Math.max(0, freq[i] - required);
        }

        if (equal) {
            return 0;
        }

        // step 3 use sliding window and try to track what more is needed to find smallest window
        int start = 0;
        int minLen = N;

        for (int end = 0; end < N; end++) {
            char c = s.charAt(end);
            freq[char2Idx(c)]--;

            while (fulfilled(freq)) {
                minLen = Math.min(end - start + 1, minLen);

                char st = s.charAt(start);
                ++freq[char2Idx(st)];
                ++start;
            }
        }

        return minLen;
    }

    private boolean fulfilled(int[] freq) {
        for(int f: freq) {
            if(f > 0) {
                return false;
            }
        }
        return true;
    }

    private int char2Idx(char c) {
        switch (c) {
            case 'Q':
                return 0;
            case 'W':
                return 1;
            case 'E':
                return 2;
        }
        return 3;
    }

}
