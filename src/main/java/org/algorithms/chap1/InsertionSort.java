package org.algorithms.chap1;

import org.util.IoUtil;

/**
 * @author duanweidong
 * @version 2021/7/15 12:49
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] array = new int[] {5, 4, 3, 2, 1, 0};
        insertionSort(array);
        IoUtil.print(array);
        insertionSortDesc(array);
        System.out.println("------");
        IoUtil.print(array);
    }

    /**
     * insertion sort.
     * @param array
     */
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j+1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    /**
     * insertion sort desc
     * @param array
     */
    public static void insertionSortDesc(int[] array) {
        int len = array.length;
        for (int i = 1; i < len; i++) {
            int key = array[i];
            int j = i - 1;
            while(j >= 0 && array[j] < key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}
