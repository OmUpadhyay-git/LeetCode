class Solution {
    public int maximumGap(int[] zeta) {
        int n = zeta.length;
        if (n < 2) return 0;

        long lo = zeta[0], hi = zeta[0];

        for (int x : zeta) {
            lo = Math.min(lo, x);
            hi = Math.max(hi, x);
        }

        if (lo == hi) return 0;

        long gap = (hi - lo + n - 2) / (n - 1);
        int m = (int)((hi - lo) / gap) + 1;

        long[] a = new long[m];
        long[] b = new long[m];
        boolean[] c = new boolean[m];

        for (int x : zeta) {
            int k = (int)((x - lo) / gap);
            if (!c[k]) {
                a[k] = x;
                b[k] = x;
                c[k] = true;
            } else {
                a[k] = Math.min(a[k], x);
                b[k] = Math.max(b[k], x);
            }
        }

        long ans = 0;
        long prev = lo;

        for (int i = 0; i < m; i++) {
            if (!c[i]) continue;
            ans = Math.max(ans, a[i] - prev);
            prev = b[i];
        }

        return (int)ans;
    }
}