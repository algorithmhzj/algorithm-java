package com.github.shoothzj.algorithm.leetcode.contest;

import java.math.BigInteger;

public class Q5173 {

    public int cheat(int n) {
        int[] resultArray = new int[]{0, 1, 1, 2, 4, 12, 36, 144, 576, 2880, 17280, 86400, 604800, 3628800, 29030400, 261273600, 612735986, 289151874, 180670593, 445364737, 344376809, 476898489, 676578804, 89209194, 338137903, 410206413, 973508979, 523161503, 940068494, 400684877, 13697484, 150672324, 164118783, 610613205, 44103617, 58486801, 462170018, 546040181, 197044608, 320204381, 965722612, 554393872, 77422176, 83910457, 517313696, 36724464, 175182841, 627742601, 715505693, 327193394, 451768713, 263673556, 755921509, 94744060, 600274259, 410695940, 427837488, 541336889, 736149184, 514536044, 125049738, 250895270, 39391803, 772631128, 541031643, 428487046, 567378068, 780183222, 228977612, 448880523, 892906519, 858130261, 622773264, 78238453, 146637981, 918450925, 514800525, 828829204, 243264299, 351814543, 405243354, 909357725, 561463122, 913651722, 732754657, 430788419, 139670208, 938893256, 28061213, 673469112, 448961084, 80392418, 466684389, 201222617, 85583092, 76399490, 500763245, 519081041, 892915734, 75763854, 682289015};
        return resultArray[n];
    }

    public int numPrimeArrangements(int n) {
        int[] primeArray = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37,
                41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        int primeCount = 0;
        for (int j : primeArray) {
            if (j <= n) {
                primeCount++;
            } else {
                break;
            }
        }
        int mod = 7 + 1000_000_000;
        return doTheResultV2(primeCount, n, mod);
    }

    private int doTheResultV2(int primeCount, int n, int mod) {
        long a = 1;
        int temp = primeCount;
        while (primeCount > 1) {
            a = a * primeCount;
            a %= mod;
            primeCount--;
        }
        int aux = n - temp;
        while (aux > 1) {
            a = a * aux;
            a %= mod;
            aux--;
        }
        return (int) a;
    }

    private int doTheResult(int primeCount, int n, int mod) {
        BigInteger a = new BigInteger("1");
        int temp = primeCount;
        while (primeCount > 1) {
            a = a.multiply(new BigInteger(String.valueOf(primeCount)));
            primeCount--;
        }
        int aux = n - temp;
        while (aux > 1) {
            a = a.multiply(new BigInteger(String.valueOf(aux)));
            aux--;
        }
        BigInteger bigInteger = a.mod(new BigInteger(String.valueOf(mod)));
        return Integer.parseInt(bigInteger.toString());
    }

    private int factorialMod(int a, int mod) {
        int result = 1;
        while (a > 1) {
            result *= a;
            result %= mod;
            a--;
        }
        return result;
    }

}
