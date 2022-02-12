package com.github.shoothzj.algorithm.nowcoder;

public class Nc73 {

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 1) {
            return array[0];
        }
        int[] aux = new int[10001];
        int bound = array.length / 2;
        for (int j : array) {
            if (aux[j] >= bound) {
                return j;
            }
            aux[j]++;
        }
        return -1;
    }

}
