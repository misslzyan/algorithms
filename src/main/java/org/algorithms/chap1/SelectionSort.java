package org.algorithms.chap1;

import java.util.Arrays;
import org.util.IoUtil;

/**
 * @author duanweidong
 * @version 2021/7/17 13:35
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] array = new int[] {5, 3, 4, 2, 1};
        selectionSort(array);
        IoUtil.print(array);
    }

    public static void selectionSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            int index = i;
            int j = i;
            for (; j < len; j++) {
                if (array[index] > array[j]) {
                    index = j;
                }
            }
            int tmp = array[i];
            array[i] = array[index];
            array[index] = tmp;
        }
    }

}
