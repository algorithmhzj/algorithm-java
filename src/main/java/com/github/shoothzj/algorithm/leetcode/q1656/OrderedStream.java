package com.github.shoothzj.algorithm.leetcode.q1656;

import java.util.ArrayList;
import java.util.List;

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
class OrderedStream {

    final String[] array;

    int index = 1;

    public OrderedStream(int n) {
        this.array = new String[n + 1];
    }

    public List<String> insert(int idKey, String value) {
        if (idKey != index) {
            array[idKey] = value;
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        result.add(value);
        index++;
        for (int i = index; i < array.length; i++) {
            if (array[i] == null) {
                break;
            }
            result.add(array[i]);
            index++;
        }
        return result;
    }
}