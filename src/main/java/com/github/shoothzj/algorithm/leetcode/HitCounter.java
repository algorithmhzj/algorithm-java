package com.github.shoothzj.algorithm.leetcode;

import java.util.LinkedList;

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
class HitCounter {

    private final LinkedList<Integer> list;

    /** Initialize your data structure here. */
    public HitCounter() {
        list = new LinkedList<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        list.addLast(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (true) {
            Integer peek = list.peekFirst();
            if (peek == null) {
                break;
            }
            if (timestamp - peek >= 300) {
                list.pollFirst();
            } else {
                break;
            }
        }
        return list.size();
    }
}
