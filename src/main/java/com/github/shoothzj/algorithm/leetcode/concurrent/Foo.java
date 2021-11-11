package com.github.shoothzj.algorithm.leetcode.concurrent;

class Foo {

    private volatile boolean fstExec = false;

    private volatile boolean secExec = false;


    public Foo() {

    }

    public void first(Runnable printFirst) {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        fstExec = true;
    }

    public void second(Runnable printSecond) {
        while (!fstExec) {
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secExec = true;
    }

    public void third(Runnable printThird) {
        while (!secExec) {

        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}