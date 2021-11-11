package com.github.shoothzj.algorithm.leetcode;

public class Q0007 {

    public int reverse(int x) {
        long aux = 0;
        while (x != 0) {
            int temp = x % 10;
            aux = aux * 10 + temp;
            x = x / 10;
        }
        if (aux < Integer.MAX_VALUE && aux > Integer.MIN_VALUE) {
            return (int) aux;
        }
        return 0;
    }

    public int reverseAnswer(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

}
