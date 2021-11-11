package com.github.shoothzj.algorithm.leetcode.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.function.IntConsumer;

class ZeroEvenOddTest {

    static class TestIntConsumer implements IntConsumer {

        @Override
        public void accept(int value) {
            System.out.print(value);
        }
    }

    @Test
    public void test10() throws Exception {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        CountDownLatch latch = new CountDownLatch(3);
        Thread zeroThread = new Thread(() -> {
            try {
                zeroEvenOdd.zero(new TestIntConsumer());
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread evenThread = new Thread(() -> {
            try {
                zeroEvenOdd.even(new TestIntConsumer());
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread oddThread = new Thread(() -> {
            try {
                zeroEvenOdd.odd(new TestIntConsumer());
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        zeroThread.start();
        evenThread.start();
        oddThread.start();
        latch.await();
    }

}