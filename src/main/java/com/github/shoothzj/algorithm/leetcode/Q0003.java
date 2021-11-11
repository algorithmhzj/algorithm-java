package com.github.shoothzj.algorithm.leetcode;

public class Q0003 {

    /**
     * Given a string, find the length of the longest substring without repeating characters.
     *
     * Examples:
     *
     * Given "abcabcbb", the answer is "abc", which the length is 3.
     *
     * Given "bbbbb", the answer is "b", with the length of 1.
     *
     * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int ans = 0;
        int[] index = new int[128];
        for (int j = 0, i = 0; j < chars.length; j++) {
            i = Math.max(index[chars[j]], i);
            ans = Math.max(ans, j - i + 1);
            index[chars[j]] = j + 1;
        }
        return ans;
    }

}
