package org.algorithms.chap4;

import org.util.IoUtil;
import org.util.Subarray;

/**
 * @author duanweidong
 * @version 2021/7/24 15:10
 */
public class FindMaximumSubarray {

    public static void main(String[] args) {
        int[] array = new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        Subarray subarray = findMaximumSubarray(array);
        IoUtil.print(subarray);
        IoUtil.print(findMaximumArrayWithDivide(array));
        IoUtil.print(findMaximumSubarrayQuickly(array));
    }

    /**
     * θ(n^2)
     *
     * @param array
     * @return
     */
    public static Subarray findMaximumSubarray(int[] array) {
        final int len = array.length;
        int maxSum = Integer.MIN_VALUE;
        Subarray subarray = new Subarray();
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += array[j];
                if (sum > maxSum) {
                    maxSum = sum;
                    subarray.low = i;
                    subarray.high = j + 1;
                    subarray.array = array;
                }
            }
        }
        return subarray;
    }

    /**
     * θ(n*lgn)
     *
     * @param array
     * @return
     */
    public static Subarray findMaximumArrayWithDivide(int[] array) {
        return findMaximumArrayWithDivide(array, 0, array.length);
    }

    /**
     * θ(n)
     *
     * @param array
     * @return
     */
    public static Subarray findMaximumSubarrayQuickly(int[] array) {
        final int len = array.length;
        Subarray subarray = new Subarray();
        //max(A[1....j])
        subarray.max = Integer.MIN_VALUE;
        subarray.array = array;
        int sum = 0;
        //sum(A[i....j])
        Subarray p_a = new Subarray();
        p_a.max = 0;
        for (int i = 0; i < len; i++) {
            if (p_a.max + array[i] < 0) {
                p_a.max = 0;
                p_a.low = i + 1;
                if (subarray.max < array[i]) {
                    subarray.low = i;
                    subarray.high = i + 1;
                }
            } else {
                p_a.max += array[i];
                p_a.high = i + 1;
                if (subarray.max < p_a.max) {
                    subarray.max = p_a.max;
                    subarray.low = p_a.low;
                    subarray.high = p_a.high;
                }
            }
        }
        return subarray;
    }

    private static Subarray findMaximumArrayWithDivide(int[] array, int low, int high) {
        if (high - low <= 1) {
            Subarray subarray = new Subarray();
            subarray.array = array;
            subarray.low = low;
            subarray.high = high;
            subarray.max = array[low];
            return subarray;
        }
        int mid = (high + low) / 2;
        Subarray left = findMaximumArrayWithDivide(array, low, mid);
        Subarray right = findMaximumArrayWithDivide(array, mid, high);
        Subarray cross = findMaxCrossSubarray(array, low, mid, high);
        if (left.max >= right.max && left.max >= cross.max) {
            return left;
        } else if (right.max >= left.max && right.max >= cross.max) {
            return right;
        } else {
            return cross;
        }
    }

    private static Subarray findMaxCrossSubarray(int[] array, int low, int mid, int high) {
        int maxLeft = Integer.MIN_VALUE;
        int sum = 0;
        Subarray subarray = new Subarray();
        for (int i = mid - 1; i >= low; i--) {
            sum += array[i];
            if (sum > maxLeft) {
                maxLeft = sum;
                subarray.low = i;
            }
        }
        int maxRight = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid; i < high; i++) {
            sum += array[i];
            if (sum > maxRight) {
                maxRight = sum;
                subarray.high = i + 1;
            }
        }
        subarray.array = array;
        subarray.max = maxLeft + maxRight;
        return subarray;
    }
}
