package org.algorithms.chap2;

import org.util.IoUtil;

/**
 * @author duanweidong
 * @version 2021/7/18 11:35
 */
public class HornerRule {

    public static void main(String[] args) {
        /*
         * 计算 y = x ^ 2 + 2x + 1;
         */
        int[] array = new int[] {1, 2, 1};
        int begin = 0;
        int n = 2;
        int x = 3;
        IoUtil.print(hornerRule(array, begin, n, x));
        // demo
        array = new int[] {1, 1, 2, 1};
        begin = 0;
        n = 3;
        x = 3;
        IoUtil.print(hornerRule(array, begin, n, x));
    }

    /**
     * demo:
     * y = x ^ 3 + 2x ^ 2 + x + 1;
     * => y = 1 + x( 1 + x( 2 + x))
     * 对应的参数: {1, 1, 2, 1}   0    3    x变量
     * @param array 多项式的参数
     * @param begin 起始下标
     * @param n 多项式的项数
     * @param x 多项式的x
     * @return
     */
    public static double hornerRule(int[] array, int begin, int n, int x) {
        if (n <= 0) {
            return array[begin];
        }
        return array[begin] + hornerRule(array, begin + 1, n - 1, x) * x;
    }
}
