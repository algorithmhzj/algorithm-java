package com.github.shoothzj.algorithm.binary;

/**
 * @author hezhangjian
 */
public class SearchValueInArray {

    public int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

}
