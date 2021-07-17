package org.algorithms.chap2;

import java.util.Arrays;

/**
 * @author duanweidong
 * @version 2021/7/17 13:48
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = new int[] {5, 4, 3, 2, 1};
        mergeSort(array);
        Arrays.stream(array).forEach(System.out::println);
    }

    public static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length);
    }

    public static void mergeSort(int[] array, int begin, int end) {
        if (begin == end - 1) {
            return;
        }
        int mid = (begin + end) / 2;
        mergeSort(array, begin, mid);
        mergeSort(array, mid, end);
        merge(array, begin, mid, end);
    }

    private static void merge(int[] array, int begin, int mid, int end) {
        int left = mid - begin;
        int right = end - mid;
        int[] leftArray = new int[left + 1];
        int[] rightArray = new int[right + 1];
        for (int i = 0; i < left; i++){
            leftArray[i] = array[begin + i];
        }
        for (int i = 0; i < right; i++) {
            rightArray[i] = array[mid + i];
        }
        leftArray[left] = Integer.MAX_VALUE;
        rightArray[right] = Integer.MAX_VALUE;
        int i = 0, j = 0;
        for (; begin < end; begin++) {
            if (leftArray[i] < rightArray[j]) {
                array[begin] = leftArray[i];
                i++;
            } else {
                array[begin] = rightArray[j];
                j++;
            }
        }
    }
}
