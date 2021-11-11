package com.github.shoothzj.algorithm.leetcode.contest;

public class Q5216 {

    final int mod = 7 + 1000_000_000;


    public int countVowelPermutation(int n) {
        if (n == 1) {
            return 5;
        }
        int oldaCount = 1;
        int oldeCount = 1;
        int oldiCount = 1;
        int oldoCount = 1;
        int olduCount = 1;
        int aCount = 1;
        int eCount = 1;
        int iCount = 1;
        int oCount = 1;
        int uCount = 1;
        for (int i = 1; i < n; i++) {
            aCount = addWithMod(oldeCount, oldiCount, olduCount);
            eCount = addWithMod(oldaCount, oldiCount);
            iCount = addWithMod(oldeCount, oldoCount);
            oCount = oldiCount;
            uCount = addWithMod(oldiCount, oldoCount);
            oldaCount = aCount;
            oldeCount = eCount;
            oldiCount = iCount;
            oldoCount = oCount;
            olduCount = uCount;
        }

        return addWithMod(aCount, eCount, iCount, oCount, uCount);
    }

    private int addWithMod(int... nums) {
        int res = 0;
        for (int i : nums) {
            res += i;
            res %= mod;
        }
        return res;
    }

}
