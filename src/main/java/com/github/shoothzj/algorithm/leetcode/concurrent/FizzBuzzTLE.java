package com.github.shoothzj.algorithm.leetcode.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

class FizzBuzzTLE {

    private final AtomicInteger atomicInteger = new AtomicInteger(1);

    public FizzBuzzTLE(int n) {
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) {
        while (true) {
            int i = atomicInteger.get();
            if (i % 5 != 0 && i % 3 == 0) {
                printFizz.run();
                atomicInteger.compareAndSet(i, i + 1);
            } else {
                break;
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) {
        while (true) {
            int i = atomicInteger.get();
            if (i % 3 != 0 && i % 5 == 0) {
                printBuzz.run();
                atomicInteger.compareAndSet(i, i + 1);
            } else {
                break;
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) {
        while (true) {
            int i = atomicInteger.get();
            if (i % 15 == 0) {
                printFizzBuzz.run();
                atomicInteger.compareAndSet(i, i + 1);
            } else {
                break;
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) {
        while (true) {
            int i = atomicInteger.get();
            if (i % 3 != 0 && i % 5 != 0) {
                printNumber.accept(i);
                atomicInteger.compareAndSet(i, i + 1);
            } else {
                break;
            }
        }
    }

}