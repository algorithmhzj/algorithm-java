package com.github.shoothzj.algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class Q0239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }

        int[] result = new int[nums.length - k + 1];

        //最大值的下标
        Deque<Integer> indexDeque = new LinkedList<>();
        //最大值
        Deque<Integer> valueDeque = new LinkedList<>();
        for (int i = 0; i < k - 1; i++) {
            int val = nums[i];
            while (true) {
                Integer integer = valueDeque.peekLast();
                if (integer == null || integer > val) {
                    //入栈
                    indexDeque.offerLast(i);
                    valueDeque.offerLast(val);
                    break;
                } else {
                    //出栈,继续循环
                    valueDeque.removeLast();
                    indexDeque.removeLast();
                }
            }
        }
        //开始计算result
        for (int i = k - 1; i < nums.length; i++) {
            int val = nums[i];
            //根据indexDeque判断是否出栈, 数组下标至少为 i - k
            while (true) {
                Integer integer = indexDeque.peekFirst();
                if (integer == null || integer > (i - k)) {
                    break;
                } else {
                    indexDeque.removeFirst();
                    valueDeque.removeFirst();
                }
            }
            while (true) {
                Integer integer = valueDeque.peekLast();
                if (integer == null || integer > val) {
                    //入栈
                    indexDeque.offerLast(i);
                    valueDeque.offerLast(val);
                    break;
                } else {
                    //出栈,继续循环
                    valueDeque.removeLast();
                    indexDeque.removeLast();
                }
            }
            result[i - k + 1 ] = valueDeque.peekFirst();
        }
        return result;
    }

}
