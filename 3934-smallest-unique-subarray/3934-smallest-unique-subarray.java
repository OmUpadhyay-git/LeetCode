import java.util.HashMap;
import java.util.Map;

class Solution {
    private static final long B1 = 1315423911L;
    private static final long B2 = 2654435761L;
    private static final long M1 = 1000000007L;
    private static final long M2 = 1000000009L;

    public int smallestUniqueSubarray(int[] nums) {
        int q7 = nums.length;
        long[] z1 = new long[q7 + 1];
        long[] z2 = new long[q7 + 1];
        z1[0] = 1L;
        z2[0] = 1L;
        for (int k9 = 1; k9 <= q7; k9++) {
            z1[k9] = (z1[k9 - 1] * B1) % M1;
            z2[k9] = (z2[k9 - 1] * B2) % M2;
        }

        int p2 = 1;
        int m8 = q7;
        int r4 = q7;

        while (p2 <= m8) {
            int w3 = p2 + (m8 - p2) / 2;
            if (xv9(nums, w3, z1, z2)) {
                r4 = w3;
                m8 = w3 - 1;
            } else {
                p2 = w3 + 1;
            }
        }
        return r4;
    }

    private boolean xv9(int[] d5, int t1, long[] z1, long[] z2) {
        int n0 = d5.length;
        long h1 = 0L;
        long h2 = 0L;

        for (int i = 0; i < t1; i++) {
            long v = (d5[i] % M1 + M1) % M1;
            long u = (d5[i] % M2 + M2) % M2;
            h1 = (h1 * B1 + v) % M1;
            h2 = (h2 * B2 + u) % M2;
        }

        Map<Long, Integer> c6 = new HashMap<>();
        long k = (h1 << 32) ^ (h2 & 0xffffffffL);
        c6.put(k, 1);

        long f1 = z1[t1 - 1];
        long f2 = z2[t1 - 1];

        for (int j = t1; j < n0; j++) {
            long out1 = (d5[j - t1] % M1 + M1) % M1;
            long out2 = (d5[j - t1] % M2 + M2) % M2;
            long in1 = (d5[j] % M1 + M1) % M1;
            long in2 = (d5[j] % M2 + M2) % M2;

            h1 = (h1 - (out1 * f1) % M1 + M1) % M1;
            h1 = (h1 * B1 + in1) % M1;

            h2 = (h2 - (out2 * f2) % M2 + M2) % M2;
            h2 = (h2 * B2 + in2) % M2;

            long nk = (h1 << 32) ^ (h2 & 0xffffffffL);
            c6.put(nk, c6.getOrDefault(nk, 0) + 1);
        }

        for (int cnt : c6.values()) {
            if (cnt == 1) {
                return true;
            }
        }
        return false;
    }
}