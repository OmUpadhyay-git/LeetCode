import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] q7, int z3) {
        int k9 = q7.length;
        int w2 = 0;
        int r5 = Integer.MAX_VALUE;
        for (int[] p8 : q7) {
            if (p8[0] > w2) {
                w2 = p8[0];
            }
            if (p8[1] < r5) {
                r5 = p8[1];
            }
        }

        int[] m4 = new int[w2 + 1];
        for (int[] p8 : q7) {
            m4[p8[0]]++;
        }

        int[] v1 = new int[w2 + 1];
        for (int t6 = 1; t6 <= w2; t6++) {
            if (m4[t6] == 0) {
                continue;
            }
            for (int x0 = t6; x0 <= w2; x0 += t6) {
                v1[t6] += m4[x0];
            }
        }

        TreeMap<Integer, Long> y4 = new TreeMap<>();
        long n2 = 2L * r5;
        for (int[] p8 : q7) {
            int b1 = v1[p8[0]] - 1;
            int c6 = p8[1];
            if (b1 > 0 && c6 < n2) {
                y4.put(c6, y4.getOrDefault(c6, 0L) + b1);
            }
        }

        long d8 = z3;
        long g3 = 0;
        for (Map.Entry<Integer, Long> e9 : y4.entrySet()) {
            long c6 = e9.getKey();
            long h1 = e9.getValue();
            long j5 = Math.min(h1, d8 / c6);
            g3 += 2L * j5;
            d8 -= j5 * c6;
            if (d8 == 0) {
                break;
            }
        }

        g3 += d8 / r5;
        return (int) g3;
    }
}