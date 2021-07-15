package org.algorithms.chap1;

import java.util.Arrays;

/**
 * @author duanweidong
 * @version 2021/7/15 12:49
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] array = new int[] {5, 4, 3, 2, 1, 0};
        insertionSort(array);
        Arrays.stream(array).forEach(System.out::println);
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
}
