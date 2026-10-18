
class Solution {
    private static final int MOD = 1000000007;
    private long[][] a;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        a = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            a[i][0] = a[i][i] = 1;
            for (int j = 1; j < i; j++) {
                a[i][j] = (a[i - 1][j - 1] + a[i - 1][j]) % MOD;
            }
        }

        return (int) ((f(nums) - 1 + MOD) % MOD);
    }

    private long f(int[] b) {
        int n = b.length;
        if (n <= 2) return 1;

        int[] c = new int[n];
        int[] d = new int[n];
        int x = 0, y = 0;

        for (int i = 1; i < n; i++) {
            if (b[i] < b[0]) c[x++] = b[i];
            else d[y++] = b[i];
        }

        int[] e = new int[x];
        int[] g = new int[y];
        System.arraycopy(c, 0, e, 0, x);
        System.arraycopy(d, 0, g, 0, y);

        return a[n - 1][x] * f(e) % MOD * f(g) % MOD;
    }
}
