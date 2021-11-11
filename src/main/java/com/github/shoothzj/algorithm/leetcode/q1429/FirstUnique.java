package com.github.shoothzj.algorithm.leetcode.q1429;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
class FirstUnique {

    private final Set<Integer> duplicateNumbers = new HashSet<>();

    private final LinkedHashSet<Integer> distinctNumbers = new LinkedHashSet<>();

    public FirstUnique(int[] nums) {
        for (int num : nums) {
            if (!duplicateNumbers.contains(num)) {
                if (distinctNumbers.contains(num)) {
                    distinctNumbers.remove(num);
                    duplicateNumbers.add(num);
                } else {
                    distinctNumbers.add(num);
                }
            }
        }
    }

    public int showFirstUnique() {
        Iterator<Integer> iterator = distinctNumbers.iterator();
        return iterator.hasNext() ? iterator.next() : -1;
    }

    public void add(int value) {
        if (duplicateNumbers.contains(value)) {
        } else {
            if (distinctNumbers.contains(value)) {
                distinctNumbers.remove(value);
                duplicateNumbers.add(value);
            } else {
                distinctNumbers.add(value);
            }
        }
    }
}