class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int mod = 1000000007;

        int[][] a = new int[m][n];
        int[][] b = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    a[i][j] = i * n + j;
                    b[i][j] = i * n + j;
                } else {
                    a[i][j] = i + 1 < m ? b[i + 1][j] : -1;
                    b[i][j] = j + 1 < n ? a[i][j + 1] : -1;
                }
            }
        }

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int v = dp[i][j];

                if (v == 0) {
                    continue;
                }

                if (j + 1 < n) {
                    int t = a[i][j + 1];

                    if (t != -1) {
                        int r = t / n;
                        int c = t % n;

                        dp[r][c] = (int) ((dp[r][c] + (long) v) % mod);
                    }
                }

                if (i + 1 < m) {
                    int t = b[i + 1][j];

                    if (t != -1) {
                        int r = t / n;
                        int c = t % n;

                        dp[r][c] = (int) ((dp[r][c] + (long) v) % mod);
                    }
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}