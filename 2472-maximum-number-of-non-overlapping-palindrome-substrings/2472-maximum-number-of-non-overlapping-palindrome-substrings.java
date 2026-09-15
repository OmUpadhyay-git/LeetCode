class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        char[] a = s.toCharArray();

        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0, l = 0, r = -1; i < n; i++) {
            int z = i > r ? 1 : Math.min(x[l + r - i], r - i + 1);
            while (i - z >= 0 && i + z < n && a[i - z] == a[i + z]) z++;
            x[i] = z--;
            if (i + z > r) {
                l = i - z;
                r = i + z;
            }
        }

        for (int i = 0, l = 0, r = -1; i < n; i++) {
            int z = i > r ? 0 : Math.min(y[l + r - i + 1], r - i + 1);
            while (i - z - 1 >= 0 && i + z < n && a[i - z - 1] == a[i + z]) z++;
            y[i] = z--;
            if (i + z > r) {
                l = i - z - 1;
                r = i + z;
            }
        }

        int[] q = new int[n + 1];

        for (int i = k; i <= n; i++) {
            q[i] = q[i - 1];

            int l = i - k;
            int r = i - 1;

            if (z(a, x, y, l, r))
                q[i] = Math.max(q[i], q[i - k] + 1);

            if (i > k) {
                l = i - k - 1;

                if (z(a, x, y, l, r))
                    q[i] = Math.max(q[i], q[i - k - 1] + 1);
            }
        }

        return q[n];
    }

    private boolean z(char[] a, int[] x, int[] y, int l, int r) {
        int m = r - l + 1;

        if (m < 1 || l < 0)
            return false;

        if ((m & 1) == 1) {
            int c = (l + r) >> 1;
            return x[c] >= (m >> 1) + 1;
        }

        int c = (l + r + 1) >> 1;
        return y[c] >= m >> 1;
    }
}