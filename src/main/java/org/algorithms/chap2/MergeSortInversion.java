package org.algorithms.chap2;

import org.util.IoUtil;

/**
 * 给一个数组，求逆序对的个数
 * @author duanweidong
 * @version 2021/7/18 12:12
 */
public class MergeSortInversion {

    public static void main(String[] args) {
        int[] array = new int[] {2, 3, 8, 6, 1};
        IoUtil.print(mergeSortInversion(array));
        array = new int[] {2, 3, 8, 1};
        IoUtil.print(mergeSortInversion(array));
    }

    /**
     * θ(n*lgn)
     * @param array
     * @return
     */
    public static int mergeSortInversion(int[] array) {
        return mergeSortInversion(array, 0, array.length);
    }

    public static int mergeSortInversion(int[] array, int begin, int end) {
        if (end - begin <= 1) {
            return 0;
        }
        int mid = (begin + end) / 2;
        int numLeft = mergeSortInversion(array, begin, mid);
        int numRight = mergeSortInversion(array, mid, end);
        return numLeft + numRight + merge(array, begin, mid, end);
    }

    private static int merge(int[] array, int begin, int mid, int end) {
        int lSize = mid - begin;
        int rSize = end - mid;
        int[] lArray = new int[lSize];
        int[] rArray = new int[rSize];
        for (int i = 0; i < lSize; i++){
            lArray[i] = array[begin + i];
        }
        for (int i = 0; i < rSize; i++) {
            rArray[i] = array[mid + i];
        }
        int num = 0;
        int len = end - begin;
        int l = 0, r = 0;
        for (int i = 0; i < len; i++) {
            if (l >= lSize) {
                array[begin + i] = rArray[r++];
            } else if (r >= rSize) {
                array[begin + i] = lArray[l++];
            } else if (lArray[l] <= rArray[r]) {
                array[begin + i] = lArray[l++];
            } else {
                num += lSize - l;
                array[begin + i] = rArray[r++];
            }
        }
        return num;
    }
}
