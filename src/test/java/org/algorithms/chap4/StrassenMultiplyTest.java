package org.algorithms.chap4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * @author duanweidong
 * @version 2021/7/25 20:56
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class StrassenMultiplyTest {

    private int[][] a;

    private int[][] b;

    @Before
    public void init() {
        a = new int[][]{
            {2, 3, 0, 0},
            {4, 5, 0, 0},
            {1, 5, 0, 0},
            {0, 0, 0, 0}
        };
        b = new int[][]{
            {2, 3, 4, 0},
            {3, 4, 5, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
    }

    @Test
    public void testSquareMatrixMultiply() {
        int[][] c = StrassenMultiply.squareMatrixMultiply(a, b);
        int[][] expect = new int[][]{
            {13, 18, 23, 0},
            {23, 32, 41, 0},
            {17, 23, 29, 0},
            {0, 0, 0, 0}
        };
        assertTrue(expect, c);
    }

    @Test
    public void testStrassenMultiply() {

        a = new int[][]{
            {1, 1},
            {1, 1}
        };
        b = new int[][]{
            {1, 1},
            {1, 1}
        };
        int[][] c = StrassenMultiply.strassenMultiply(a, b);
        int[][] expect = new int[][]{
            {2, 2},
            {2, 2}
        };
        assertTrue(expect, c);
        System.out.println("=====");
        a = new int[][]{
            {2, 3, 0, 0},
            {4, 5, 0, 0},
            {1, 5, 0, 0},
            {0, 0, 0, 0}
        };
        b = new int[][]{
            {2, 3, 4, 0},
            {3, 4, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
        c = StrassenMultiply.strassenMultiply(a, b);
        expect = new int[][]{
            {4, 4, 4, 4},
            {4, 4, 4, 4},
            {4, 4, 4, 4},
            {4, 4, 4, 4}
        };
        assertTrue(expect, c);
    }

    @Test
    public void testAdd() {
        int[][] d = StrassenMultiply.negative(a, 0, 0, a.length, a[0].length);
        int[][] c = StrassenMultiply
            .add(a, 0, 0, a.length, a[0].length, d, 0, 0, d.length, d[0].length);
        int[][] expect = new int[][]{
            {0, 0},
            {0, 0},
            {0, 0}
        };
        assertTrue(expect, c);
    }

    @Test
    public void testNegative() {
        int[][] c = StrassenMultiply.negative(a, 0, 0, a.length, a[0].length);
        int[][] expect = new int[][]{
            {-2, -3},
            {-4, -5},
            {-1, -5}
        };
        assertTrue(expect, c);
    }

    @Test
    public void testMinus() {
        int[][] c = StrassenMultiply.minus(a, a);
        int[][] expected = new int[][]{
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
    }

    private void assertTrue(int[][] expect, int[][] c) {
        Assert.assertEquals(expect.length, c.length);
        for (int i = 0; i < c.length; i++) {
            Assert.assertArrayEquals(expect[i], c[i]);
        }
    }
}
