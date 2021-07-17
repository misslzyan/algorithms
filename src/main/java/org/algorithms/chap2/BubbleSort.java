package org.algorithms.chap2;

import org.util.IoUtil;

/**
 * @author duanweidong
 * @version 2021/7/17 22:10
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = new int[] {5, 4, 3, 2, 1};
        bubbleSort(array);
        IoUtil.print(array);
    }

    public static void bubbleSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            int j = len - 1;
            for (; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                }
            }
        }
    }
}
