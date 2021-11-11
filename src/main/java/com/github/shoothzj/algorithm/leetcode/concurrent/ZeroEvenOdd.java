package com.github.shoothzj.algorithm.leetcode.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

class ZeroEvenOdd {

    private final Lock lock;

    private boolean zeroFlag;

    private boolean evenFlag;

    private boolean oddFlag;

    private final Condition zeroCondition;

    private final Condition evenCondition;

    private final Condition oddCondition;

    private final int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.lock = new ReentrantLock();
        this.zeroFlag = true;
        this.zeroCondition = lock.newCondition();
        this.evenCondition = lock.newCondition();
        this.oddCondition = lock.newCondition();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (!zeroFlag) {
                    zeroCondition.await();
                }
                printNumber.accept(0);
                zeroFlag = false;
                if (i % 2 == 0) {
                    oddFlag = true;
                    oddCondition.signal();
                } else {
                    //it's time to print even
                    evenFlag = true;
                    evenCondition.signal();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i+=2) {
            lock.lock();
            try {
                while (!evenFlag) {
                    evenCondition.await();
                }
                printNumber.accept(i);
                evenFlag = false;
                zeroFlag = true;
                zeroCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i+=2) {
            lock.lock();
            try {
                while (!oddFlag) {
                    oddCondition.await();
                }
                printNumber.accept(i);
                oddFlag = false;
                zeroFlag = true;
                zeroCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}