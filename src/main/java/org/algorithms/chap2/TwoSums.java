package org.algorithms.chap2;

import org.util.IoUtil;

/**
 * @author duanweidong
 * @version 2021/7/17 16:33
 */
public class TwoSums {

    public static void main(String[] args) {
        int[] array = new int[] {3, 4, 2, 4, 5};
        IoUtil.print(existTwoSums(array, 8));
        IoUtil.print(existTwoSums(array, 7));
        IoUtil.print(existTwoSums(array, 9));
        IoUtil.print(existTwoSums(array, 10));
    }

    /**
     * θ(n*lgn)
     * @param array
     * @param target
     * @return
     */
    public static boolean existTwoSums(int[] array, int target) {
        MergeSort.mergeSort(array);
        int len = array.length;
        for (int i = 0; i < len; i++) {
            int key = array[i];
            int toFind = target - key;
            int low = i + 1;
            int high = len;
            while (low < high) {
                int mid = (low + high) / 2;
                if (array[mid] == toFind) {
                    return true;
                } else if (toFind < array[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }
}
