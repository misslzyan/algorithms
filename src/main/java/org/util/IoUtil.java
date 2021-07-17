package org.util;

import java.util.List;

/**
 * @author duanweidong
 * @version 2021/7/17 16:04
 */
public class IoUtil {

    public static <T> void print(List<T> list) {
        list.stream().map(v -> v + "\t").forEach(System.out::print);
    }

    public static void print(Node list) {
        list.toList().stream().map(v -> v + "\t").forEach(System.out::print);
    }
}
