
import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        if (k < 1) return -1;
        if (n == 1) return 0;

        k = Math.min(k, n);

        List<int[]>[] a = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            a[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            a[e[0]].add(new int[]{e[1], e[2]});
        }

        long[][] b = new long[n][k + 1];

        for (long[] c : b) {
            Arrays.fill(c, Long.MAX_VALUE);
        }

        PriorityQueue<long[]> d = new PriorityQueue<>(
            (x, y) -> Long.compare(x[0], y[0])
        );

        b[0][1] = 0;
        d.offer(new long[]{0, 0, 1});

        while (!d.isEmpty()) {
            long[] e = d.poll();

            long f = e[0];
            int g = (int) e[1];
            int h = (int) e[2];

            if (f != b[g][h]) continue;

            if (g == n - 1) return (int) f;

            for (int[] i : a[g]) {
                int j = i[0];
                int l = i[1];

                int m = labels.charAt(g) == labels.charAt(j)
                    ? h + 1 : 1;

                if (m > k) continue;

                long o = f + l;

                if (o < b[j][m]) {
                    b[j][m] = o;
                    d.offer(new long[]{o, j, m});
                }
            }
        }

        return -1;
    }
}
