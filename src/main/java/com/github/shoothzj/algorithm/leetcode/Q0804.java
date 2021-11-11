package com.github.shoothzj.algorithm.leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Q0804 {

    private static final String[] morseArray = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
            "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> collect = Arrays.stream(words).map(s -> {
            char[] chars = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char ch : chars) {
                sb.append(morseArray[ch - 'a']);
            }
            return sb.toString();
        }).collect(Collectors.toSet());
        return collect.size();
    }

}
