class Solution {
    public int largestOverlap(int[][] a, int[][] b) {
        int n = a.length, z = 0;

        for (int x = -n + 1; x < n; x++) {
            for (int y = -n + 1; y < n; y++) {
                int c = 0;

                for (int i = 0; i < n; i++) {
                    int p = i + x;
                    if (p < 0 || p >= n) continue;

                    for (int j = 0; j < n; j++) {
                        int q = j + y;
                        if (q >= 0 && q < n && a[i][j] == 1 && b[p][q] == 1)
                            c++;
                    }
                }

                z = Math.max(z, c);
            }
        }

        return z;
    }
}