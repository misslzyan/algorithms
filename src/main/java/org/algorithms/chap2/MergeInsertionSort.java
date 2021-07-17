package org.algorithms.chap2;

import org.util.IoUtil;

/**
 * @author duanweidong
 * @version 2021/7/17 16:48
 */
public class MergeInsertionSort {

    public static void main(String[] args) {
        int[] array = new int[] {5, 4, 3, 2, 1};
        mergeInsertionSort(array, 6);
        IoUtil.print(array);
        mergeInsertionSort(array, 5);
        IoUtil.print(array);
        mergeInsertionSort(array, 4);
        IoUtil.print(array);
        mergeInsertionSort(array, 3);
        IoUtil.print(array);
        mergeInsertionSort(array, 1);
        IoUtil.print(array);
        mergeInsertionSort(array, 2);
        IoUtil.print(array);
    }

    public static void mergeInsertionSort(int[] array, int k) {
        mergeInsertionSort(array, 0, array.length, k);
    }

    public static void mergeInsertionSort(int[] array, int begin, int end, int k) {
        if (end - begin <= k) {
            insertionSort(array, begin, end);
            return;
        }
        int mid = (begin + end) / 2;
        mergeInsertionSort(array, begin, mid, k);
        mergeInsertionSort(array, mid, end, k);
        merge(array, begin, mid, end);
    }

    private static void merge(int[] array, int begin, int mid, int end) {
        int lSize = mid - begin;
        int rSize = end - mid;
        int[] lArray = new int[lSize];
        int[] rArray = new int[rSize];
        for (int i = 0; i < lSize; i++) {
            lArray[i] = array[begin + i];
        }
        for (int i = 0; i < rSize; i++) {
            rArray[i] = array[mid + i];
        }
        int len = end - begin;
        int l = 0;
        int r = 0;
        for (int i = 0; i < len; i++) {
            if (l >= lSize) {
                array[begin + i] = rArray[r];
                r++;
            } else if (r >= rSize) {
                array[begin + i] = lArray[l];
                l++;
            } else if (lArray[l] <= rArray[r]) {
                array[begin + i] = lArray[l];
                l++;
            } else {
                array[begin + i] = rArray[r];
                r++;
            }
        }
    }

    private static void insertionSort(int[] array, int begin, int end) {
        int len = end - begin;
        for (int i = 1; i < len; i++) {
            int j = i - 1;
            int key = array[begin + i];
            while (j >= 0 && array[begin + j] > key ) {
                array[begin + j + 1] = array[begin + j];
                j--;
            }
            array[begin + j + 1] = key;
        }
    }
}
