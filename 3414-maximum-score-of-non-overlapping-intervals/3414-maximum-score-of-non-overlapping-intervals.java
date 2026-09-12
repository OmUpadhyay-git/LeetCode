import java.util.*;

class Solution {
    static class X {
        long a;
        int[] b;

        X(long a, int[] b) {
            this.a = a;
            this.b = b;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        int[][] a = new int[n][4];

        for (int i = 0; i < n; i++) {
            a[i][0] = intervals.get(i).get(0);
            a[i][1] = intervals.get(i).get(1);
            a[i][2] = intervals.get(i).get(2);
            a[i][3] = i;
        }

        Arrays.sort(a, (x, y) -> {
            if (x[0] != y[0]) return Integer.compare(x[0], y[0]);
            if (x[1] != y[1]) return Integer.compare(x[1], y[1]);
            return Integer.compare(x[3], y[3]);
        });

        int[] z = new int[n];

        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n;
            while (l < r) {
                int m = (l + r) >>> 1;
                if (a[m][0] > a[i][1])
                    r = m;
                else
                    l = m + 1;
            }
            z[i] = l;
        }

        X[][] dp = new X[n + 1][5];

        for (int j = 0; j <= 4; j++)
            dp[n][j] = new X(0, new int[0]);

        for (int i = n - 1; i >= 0; i--) {
            dp[i][0] = new X(0, new int[0]);

            for (int j = 1; j <= 4; j++) {
                X p = dp[i + 1][j];
                X q = dp[z[i]][j - 1];

                int[] v = Arrays.copyOf(q.b, q.b.length + 1);
                v[v.length - 1] = a[i][3];
                Arrays.sort(v);

                X w = new X(q.a + a[i][2], v);

                if (w.a > p.a || (w.a == p.a && cmp(w.b, p.b) < 0))
                    dp[i][j] = w;
                else
                    dp[i][j] = p;
            }
        }

        return dp[0][4].b;
    }

    private int cmp(int[] a, int[] b) {
        int n = Math.min(a.length, b.length);

        for (int i = 0; i < n; i++) {
            if (a[i] != b[i])
                return Integer.compare(a[i], b[i]);
        }

        return Integer.compare(a.length, b.length);
    }
}