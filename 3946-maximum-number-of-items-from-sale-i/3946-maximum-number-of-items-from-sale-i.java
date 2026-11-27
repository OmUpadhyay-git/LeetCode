class Solution {
    private int x9q(int[][] v4m, int z2k) {
        int r7p = v4m[z2k][0];
        int w1n = 0;
        for (int t8b = 0; t8b < v4m.length; t8b++) {
            if (t8b != z2k && v4m[t8b][0] % r7p == 0) {
                w1n++;
            }
        }
        return 1 + w1n;
    }

    public int maximumSaleItems(int[][] q5j, int h3d) {
        int[] k8s = new int[h3d + 1];
        int g6f = Integer.MAX_VALUE;
        for (int[] c2y : q5j) {
            if (c2y[1] < g6f) {
                g6f = c2y[1];
            }
        }
        for (int m9l = 0; m9l < q5j.length; m9l++) {
            int p4a = q5j[m9l][1];
            int e7v = x9q(q5j, m9l);
            for (int u1w = h3d; u1w >= p4a; u1w--) {
                int n6r = k8s[u1w - p4a] + e7v;
                if (n6r > k8s[u1w]) {
                    k8s[u1w] = n6r;
                }
            }
        }
        int d5x = 0;
        for (int b3z = 0; b3z <= h3d; b3z++) {
            int y8t = k8s[b3z] + (h3d - b3z) / g6f;
            if (y8t > d5x) {
                d5x = y8t;
            }
        }
        return d5x;
    }
}