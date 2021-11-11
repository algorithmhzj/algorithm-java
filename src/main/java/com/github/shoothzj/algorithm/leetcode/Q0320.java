package com.github.shoothzj.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hezhangjian
 */
public class Q0320 {

    public List<String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList<>();
        // loop through all possible x
        for (int x = 0; x < (1 << word.length()); ++x) {
            ans.add(abbr(word, x));
        }
        return ans;
    }

    /**
     * build the abbreviation for word from number x
     *
     * @param word
     * @param x
     * @return
     */
    private String abbr(String word, int x) {
        StringBuilder builder = new StringBuilder();
        int k = 0, n = word.length(); // k is the count of consecutive ones in x
        for (int i = 0; i < n; ++i, x >>= 1) {
            if ((x & 1) == 0) { // bit is zero, we keep word.charAt(i)
                if (k != 0) { // we have abbreviated k characters
                    builder.append(k);
                    k = 0; // reset the counter k
                }
                builder.append(word.charAt(i));
            }
            // bit is one, increase k
            else {
                ++k;
            }
        }
        if (k != 0) {
            //don't forget to append the last k if non zero
            builder.append(k);
        }
        return builder.toString();
    }

}
