package org.algorithms.chap2;

import java.util.Arrays;
import org.util.IoUtil;

/**
 * @author duanweidong
 * @version 2021/7/17 14:27
 */
public class BinaryInsertionSort {

    public static void main(String[] args) {
        int[] array = new int[] {5, 4, 3, 2, 2, 1};
        binaryInsertionSort(array);
        IoUtil.print(array);
    }

    public static void binaryInsertionSort(int[] array) {
        int len = array.length;
        for (int i = 1; i < len; i++) {
            int key = array[i];
            int begin = 0;
            int end = i;
            int mid = 0;
            while (begin < end) {
                mid = (begin + end) / 2;
                if (key > array[mid]) {
                    begin = mid + 1;
                } else {
                    end = mid;
                }
            }
            int j = i;
            while (j > mid) {
                array[j] = array[j - 1];
                j--;
            }
            array[mid] = key;
        }
    }
}
