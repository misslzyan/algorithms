package org.util;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

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

    public static void print(boolean bool) {
        System.out.println(bool);
    }

    public static void print(Subarray subarray) {
        int low = subarray.low;
        int high = subarray.high;
        int[] array = subarray.array;
        StringJoiner joiner = new StringJoiner(" ");
        for (int i = low; i < high; i++) {
            joiner.add(array[i] + "");
        }
        System.out.println(joiner.toString());
    }

    public static void print(double num) {
        System.out.println(num);
    }

    public static void print(int num) {
        System.out.println(num);
    }

    public static String addSpace(int val) {
        return val + "\t";
    }

    public static String addSpace(Object val) {
        return val + "\t";
    }
}
