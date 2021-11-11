package com.github.shoothzj.algorithm.leetcode;

import java.util.PriorityQueue;

/**
 * @author hezhangjian
 */
public class Q0502 {

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        mergeSort(Capital, 0, Capital.length - 1, Profits);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int res = W;
        int capitalIndex = 0;
        for (int i = 0; i < Math.min(k, Profits.length); i++) {
            for (;capitalIndex < Capital.length; capitalIndex++) {
                if (Capital[capitalIndex] > res) {
                    capitalIndex--;
                    break;
                }
                priorityQueue.add(Profits[capitalIndex]);
            }

            //pop出一个
            Integer poll = priorityQueue.poll();
            if (poll != null) {
                res += poll;
            }

        }
        return res;
    }

    private void mergeSort(int[] a, int low, int high, int[] b) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            mergeSort(a, low, mid, b);
            // 右边
            mergeSort(a, mid + 1, high, b);
            // 左右归并
            merge(a, low, mid, high, b);
        }
    }

    private void merge(int[] a, int low, int mid, int high, int[] b) {
        int[] temp = new int[high - low + 1];
        int[] tempB = new int[high - low + 1];
        // 左指针
        int i = low;
        // 右指针
        int j = mid + 1;
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                tempB[k] = b[i];
                temp[k++] = a[i++];
            } else {
                tempB[k] = b[j];
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            tempB[k] = b[i];
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            tempB[k] = b[j];
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            b[k2 + low] = tempB[k2];
            a[k2 + low] = temp[k2];
        }
    }

}
