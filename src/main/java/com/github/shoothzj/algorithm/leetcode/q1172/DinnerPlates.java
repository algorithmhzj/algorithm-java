package com.github.shoothzj.algorithm.leetcode.q1172;

import java.util.ArrayList;
import java.util.List;

class DinnerPlates {

    private final int capacity;

    private final List<Integer> list = new ArrayList<>();

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
    }

    public void push(int val) {
        list.add(val);
    }

    public int pop() {
        if (list.size() == 0) {
            return -1;
        } else {
            Integer integer = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return integer;
        }
    }

    public int popAtStack(int index) {
        int lowerIndex = (index - 1) * capacity;
        int highIndex = index * capacity + 1;
        int maxIndex = list.size() - 1;
        if (maxIndex < lowerIndex) {
            return -1;
        } else {
            return list.get(Math.min(maxIndex, highIndex));
        }
    }
}