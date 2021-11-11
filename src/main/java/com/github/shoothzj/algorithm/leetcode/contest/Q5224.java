package com.github.shoothzj.algorithm.leetcode.contest;

public class Q5224 {

    final int mod = 7 + 1000_000_000;

    public int dieSimulator(int n, int[] rollMax) {
        long[][] oldArray = new long[7][16];
        //in the beginning
        for (int i = 1; i <= 6; i++) {
            oldArray[i][1] = 1;
        }
        //loop
        for (int i = 1; i < n; i++) {
            long[][] newArray = new long[7][16];
            for (int j = 1; j <= 6; j++) {
                for (int k = 1; k <= 15; k++) {
                    long aux = oldArray[j][k];
                    if (aux == 0) {
                        continue;
                    }
                    for (int temp = 1; temp <= 6; temp++) {
                        //这是给temp代表的类加
                        if (j == temp) {
                            if (k == rollMax[j - 1]) {
                                continue;
                            }
                            long swap = newArray[temp][k + 1] + aux;
                            newArray[temp][k + 1] = swap % mod;
                        } else {
                            long swap = newArray[temp][1] + aux;
                            newArray[temp][1] = swap % mod;
                        }
                    }
                }
            }
            oldArray = newArray;
        }
        //cal for the result
        long res = 0;
        for (int i = 0; i <= 6; i++) {
            for (int j = 0; j <= 15; j++) {
                res += oldArray[i][j];
                res %= mod;
            }
        }
        return (int) res;
    }

}
