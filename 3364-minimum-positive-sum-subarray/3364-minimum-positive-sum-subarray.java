
import java.util.*;

class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        long[] a = new long[n + 1];

        for (int i = 0; i < n; i++) {
            a[i + 1] = a[i] + nums.get(i);
        }

        TreeMap<Long, Integer> b = new TreeMap<>();
        long c = Long.MAX_VALUE;

        for (int i = l; i <= n; i++) {
            long d = a[i - l];
            b.put(d, b.getOrDefault(d, 0) + 1);

            int e = i - r - 1;

            if (e >= 0) {
                long f = a[e];
                int g = b.get(f);

                if (g == 1) {
                    b.remove(f);
                } else {
                    b.put(f, g - 1);
                }
            }

            Long h = b.lowerKey(a[i]);

            if (h != null) {
                c = Math.min(c, a[i] - h);
            }
        }

        return c == Long.MAX_VALUE ? -1 : (int) c;
    }
}
