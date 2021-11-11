package com.github.shoothzj.algorithm.leetcode.contest;

/**
 * @author hezhangjian
 */
public class Q5258 {

    final int[] auxArray = new int[26];


    int result = 0;

    public int maxScoreWords(String[] words, char[] letters, int[] scoreArray) {
        for (char ch: letters) {
            auxArray[ch - 'a']++;
        }
        int[][] wordArray = new int[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (char ch: words[i].toCharArray()) {
                wordArray[i][ch - 'a']++;
            }
        }
        dfs(words, wordArray, 0, scoreArray, 0);
        return result;
    }

    private void dfs(String[] words, int[][] wordArray, int index, int[] scoreArray, int score) {
        if (index == words.length) {
            //it's time to end
            result = Math.max(score, result);
            return;
        }
        boolean flag = true;
        for (int i = 0; i < 26; i++) {
            if (wordArray[index][i] > auxArray[i]) {
                flag = false;
                break;
            }
        }
        //如果flag为true,证明可以买下此单词,分两种情况
        if (flag) {
            for (int i = 0; i < 26; i++) {
                auxArray[i] = auxArray[i] - wordArray[index][i];
            }
            dfs(words, wordArray, index + 1 , scoreArray, plus(score, words[index], scoreArray));
            for (int i = 0; i < 26; i++) {
                auxArray[i] = auxArray[i] + wordArray[index][i];
            }
        }
        dfs(words, wordArray, index + 1, scoreArray, score);
    }

    private int plus(int before, String word, int[] scoreArray) {
        int res = before;
        for (char ch : word.toCharArray()) {
            res += scoreArray[ch - 'a'];
        }
        return res;
    }

}
