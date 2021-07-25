package org.algorithms.chap4;

/**
 * @author duanweidong
 * @version 2021/7/25 20:48
 */
public class StrassenMultiply {

    /**
     * θ(n^3)
     *
     * @param a
     * @param b
     * @return
     */
    public static int[][] squareMatrixMultiply(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = b[0].length;
        int[][] c = new int[rows][cols];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                int sum = 0;
                for (int k = 0; k < a[0].length; k++) {
                    sum += a[i][k] * b[k][j];
                }
                c[i][j] = sum;
            }
        }
        return c;
    }

    /**
     * θ(n^2.81) = θ(n^lg7)
     *
     * @param a
     * @param b
     * @return
     */
    public static int[][] strassenMultiply(int[][] a, int[][] b) {
        int aib = 0;
        int ajb = 0;
        int aie = a.length;
        int aje = a[0].length;
        int bib = 0;
        int bjb = 0;
        int bie = b.length;
        int bje = b[0].length;
        int am = a.length;
        int an = a[0].length;
        int bm = b.length;
        int bn = b[0].length;
        int max = findMax(am, an, bm, bn);
        if (max != am) {
            int[][] c = new int[max][max];
            for (int i = 0; i < am; i++) {
                for (int j = 0; j < an; j++) {
                    c[i][j] = a[i][j];
                }
            }
            a = c;
            c = new int[max][max];
            for (int i = 0; i < bm; i++) {
                for (int j = 0; j < bn; j++) {
                    c[i][j] = b[i][j];
                }
            }
            b = c;
        }
        int[][] res = strassenMultiplyRecursive(a, 0, 0, a.length, a[0].length, b, 0, 0, b.length,
            b[0].length);
        return res;
    }

    private static int findMax(int am, int an, int bm, int bn) {
        int max = Integer.max(am, Integer.max(an, Integer.max(bm, bn)));
        int num = 1;
        while (true) {
            if (num < max) {
                num = num << 1;
            } else {
                return num;
            }
        }
    }

    public static int[][] strassenMultiplyRecursive(int[][] a, int aib, int ajb, int aie, int aje,
        int[][] b) {
        return strassenMultiplyRecursive(a, aib, ajb, aie, aje, b, 0, 0, b.length, b[0].length);
    }

    public static int[][] strassenMultiplyRecursive(int[][] a, int[][] b, int bib, int bjb, int bie,
        int bje) {
        return strassenMultiplyRecursive(a, 0, 0, a.length, a[0].length, b, bib, bjb, bie, bje);
    }

    public static int[][] strassenMultiplyRecursive(int[][] a, int aib, int ajb, int aie, int aje,
        int[][] b, int bib, int bjb, int bie, int bje) {
        int m = aie - aib;
        int n = bje - bjb;
        int kMax = aje - ajb;
        if (m == 1 || n == 1) {
            int[][] c = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int sum = 0;
                    for (int k = 0; k < kMax; k++) {
                        sum += a[aib + i][ajb + k] * b[bib + k][bjb + j];
                        System.out.println(a[aib + i][ajb + k] + ":" + b[bib + k][bjb + j]);
                        if (a[aib + i][ajb + k] == 1 && b[bib + k][bjb + j] == 4) {
                            System.out.println(sum);
                        }
                    }
                    c[i][j] = sum;
                }
            }
            return c;
        }
        int aim = (aib + aie) / 2;
        int ajm = (ajb + aje) / 2;
        int bim = (bib + bie) / 2;
        int bjm = (bjb + bje) / 2;
        int[][] c = new int[m][n];
        // s1 = b12 - b22;
        int[][] s1 = minus(b, bib, bjm, bim, bje, b, bim, bjm, bie, bje);
        // s2 = a11 + a12;
        int[][] s2 = add(a, aib, ajb, aim, ajm, a, aib, ajm, aim, aje);
        // s3 = a21 + a22;
        int[][] s3 = add(a, aim, ajb, aie, ajm, a, aim, ajm, aie, aje);
        // s4 = b21 - b11;
        int[][] s4 = minus(b, bim, bjb, bie, bjm, b, bib, bjb, bim, bjm);
        // s5 = a11 + a22;
        int[][] s5 = add(a, aib, ajb, aim, ajm, a, aim, ajm, aie, aje);
        // s6 = b11 + b22;
        int[][] s6 = add(b, bib, bjb, bim, bjm, b, bim, bjm, bie, bje);
        // s7 = a12 - a22;
        int[][] s7 = minus(a, aib, ajm, aim, aje, a, aim, ajm, aie, aje);
        // s8 = b21 + b22;
        int[][] s8 = add(b, bim, bjb, bie, bjm, b, bim, bjm, bie, bje);
        // s9 = a11 - a21;
        int[][] s9 = minus(a, aib, ajb, aim, ajm, a, aim, ajb, aie, ajm);
        // s10 = b11 + b12;
        int[][] s10 = add(b, bib, bjb, bim, bjm, b, bim, bjb, bie, bjm);

        // p1 = a11 * s1
        int[][] p1 = strassenMultiplyRecursive(a, aib, ajb, aim, ajm, s1);
        // p2 = s2 * b22
        int[][] p2 = strassenMultiplyRecursive(s2, b, bim, bjm, bie, bje);
        // p3 = s3 * b11;
        int[][] p3 = strassenMultiplyRecursive(s3, b, bib, bjb, bim, bjm);
        // p4 = a22 * s4;
        int[][] p4 = strassenMultiplyRecursive(a, aim, ajm, aie, aje, s4);
        // p5 = s5 * s6;
        int[][] p5 = strassenMultiply(s5, s6);
        // p6 = s7 * s8
        int[][] p6 = strassenMultiply(s7, s8);
        // p7 = s9 * s10
        int[][] p7 = strassenMultiply(s9, s10);

        // c11 = p5 + p4 - p2 + p6
        int[][] c11 = add(minus(add(p5, p4), p2), p6);
        // c12 = p1 + p2
        int[][] c12 = add(p1, p2);
        // c21 = p3 + p4
        int[][] c21 = add(p3, p4);
        // c22 = p5 + p1 - p3 - p7
        int[][] c22 = minus(minus(add(p5, p1), p3), p7);
        if (c21[0][0] == 16) {
            System.out.println(16);
        }
        return combine(c11, c12, c21, c22);
    }

    private static int[][] combine(int[][] c11, int[][] c12, int[][] c21, int[][] c22) {
        int m = c11.length + c21.length;
        int n = c11[0].length + c12[0].length;
        int[][] c = new int[m][n];
        // c11
        for (int i = 0; i < c11.length; i++) {
            for (int j = 0; j < c11[i].length; j++) {
                c[i][j] = c11[i][j];
            }
        }

        // c12
        for (int i = 0; i < c12.length; i++) {
            for (int j = 0; j < c12[i].length; j++) {
                c[i][c11[0].length + j] = c12[i][j];
            }
        }

        // c21
        for (int i = 0; i < c21.length; i++) {
            for (int j = 0; j < c21[i].length; j++) {
                c[c11.length + i][j] = c21[i][j];
            }
        }

        // c22
        for (int i = 0; i < c22.length; i++) {
            for (int j = 0; j < c22[i].length; j++) {
                c[c11.length + i][c11[0].length + j] = c22[i][j];
            }
        }
        return c;
    }

    public static int[][] minus(int[][] a, int aib, int ajb, int aie, int aje,
        int[][] b, int bib, int bjb, int bie, int bje) {
        int[][] tmp = negative(b, bib, bjb, bie, bje);
        return add(a, aib, ajb, aie, aje, tmp, 0, 0, tmp.length, tmp[0].length);
    }

    public static int[][] minus(int[][] a, int[][] b) {
        return minus(a, 0, 0, a.length, a[0].length, b, 0, 0, b.length, b[0].length);
    }


    public static int[][] add(int[][] a, int[][] b) {
        return add(a, 0, 0, a.length, a[0].length, b, 0, 0, b.length, b[0].length);
    }

    public static int[][] add(int[][] a, int aib, int ajb, int aie, int aje,
        int[][] b, int bib, int bjb, int bie, int bje) {
        int m = aie - aib;
        int n = aje - ajb;
        int[][] c = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = a[aib + i][ajb + j] + b[bib + i][bjb + j];
            }
        }
        return c;
    }

    public static int[][] negative(int[][] a) {
        return negative(a, 0, 0, a.length, a[0].length);
    }

    public static int[][] negative(int[][] a, int aib, int ajb, int aie, int aje) {
        int m = aie - aib;
        int n = aje - ajb;
        int[][] b = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = -a[aib + i][ajb + j];
            }
        }
        return b;
    }
}
