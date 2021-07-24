package org.util;

import com.sun.tools.javac.util.List;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.algorithms.chap4.FindMaximumSubarray;
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
            return List.of(first - start, second - first, end - second)
                .stream()
                .map(l -> l.toString())
                .collect(Collectors.joining(","));
        }, 1, 10);
    }

    private void run(Function<Integer, String> function, int begin, int end) {
        IoUtil.print(IntStream.rangeClosed(begin, end).mapToObj(i -> function.apply(i)));
    }

    private int[] createArray(int size) {
        Random random = new Random();
        return random.ints(-100, 100)
            .limit(size)
            .toArray();
    }
}
