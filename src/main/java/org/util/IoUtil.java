package org.util;

import java.util.Arrays;
import java.util.List;

/**
 * @author duanweidong
 * @version 2021/7/17 16:04
 */
public class IoUtil {

    public static <T> void print(List<T> list) {
        list.stream().map(IoUtil::addSpace).forEach(System.out::print);
        System.out.println();
    }

    public static void print(Node list) {
        list.toList().stream().map(IoUtil::addSpace).forEach(System.out::print);
        System.out.println();
    }

    public static void print(int[] array) {
        Arrays.stream(array).mapToObj(IoUtil::addSpace).forEach(System.out::print);
        System.out.println();
    }

    public static String addSpace(int val) {
        return val + "\t";
    }

    public static String addSpace(Object val) {
        return val + "\t";
    }
}
