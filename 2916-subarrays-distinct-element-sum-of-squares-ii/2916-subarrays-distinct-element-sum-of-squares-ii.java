
import java.util.*;

class Solution {
    static final long MOD = 1000000007L;
    long[] a, b, c;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        a = new long[4 * n];
        b = new long[4 * n];
        c = new long[4 * n];

        HashMap<Integer, Integer> d = new HashMap<>();
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int l = d.getOrDefault(nums[i], -1) + 1;
            d.put(nums[i], i);
            h(1, 0, n - 1, l, i);
            ans = (ans + b[1]) % MOD;
        }

        return (int) ans;
    }

    void h(int v, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            long z = r - l + 1L;
            b[v] = (b[v] + 2 * a[v] + z) % MOD;
            a[v] = (a[v] + z) % MOD;
            c[v]++;
            return;
        }

        p(v, l, r);
        int m = (l + r) >>> 1;

        if (ql <= m) h(v * 2, l, m, ql, qr);
        if (qr > m) h(v * 2 + 1, m + 1, r, ql, qr);

        a[v] = (a[v * 2] + a[v * 2 + 1]) % MOD;
        b[v] = (b[v * 2] + b[v * 2 + 1]) % MOD;
    }

    void p(int v, int l, int r) {
        if (c[v] == 0 || l == r) return;

        int m = (l + r) >>> 1;
        q(v * 2, l, m, c[v]);
        q(v * 2 + 1, m + 1, r, c[v]);
        c[v] = 0;
    }

    void q(int v, int l, int r, long z) {
        long len = r - l + 1L;
        b[v] = (b[v] + 2 * z % MOD * a[v] % MOD
                + z * z % MOD * len % MOD) % MOD;
        a[v] = (a[v] + z * len) % MOD;
        c[v] += z;
    }
}
