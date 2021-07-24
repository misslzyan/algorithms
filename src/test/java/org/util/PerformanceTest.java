package org.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.algorithms.chap4.FindMaximumSubarray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * @author duanweidong
 * @version 2021/7/24 16:43
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class PerformanceTest {

    @Before
    public void init() {

    }

    @Test
    public void testFindMaximumSubarray() {
        run((i) -> {
            int[] array = createArray(i);
            long start = CommonUtil.currentTimestamp();
            FindMaximumSubarray.findMaximumSubarrayQuickly(array);
            long first = CommonUtil.currentTimestamp();
            FindMaximumSubarray.findMaximumArrayWithDivide(array);
            long second = CommonUtil.currentTimestamp();
            FindMaximumSubarray.findMaximumSubarray(array);
            long end = CommonUtil.currentTimestamp();
            List<Long> list = new ArrayList<>();
            list.add(first - start);
            list.add(second - first);
            list.add(end - second);
            return list.stream()
                .map(l -> l.toString())
                .collect(Collectors.joining(","));
        }, 1, 10);
        Assert.assertEquals(true, true);
    }

    private void run(Function<Integer, String> function, int begin, int end) {
        IntStream.rangeClosed(begin, end).mapToObj(i -> function.apply(i));
    }

    private int[] createArray(int size) {
        Random random = new Random();
        return random.ints(-100, 100)
            .limit(size)
            .toArray();
    }
}
