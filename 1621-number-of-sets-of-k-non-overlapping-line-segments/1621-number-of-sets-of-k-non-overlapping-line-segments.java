class Solution {
    public int numberOfSets(int n, int k) {
        long mod = 1000000007L;
        int a = n + k - 1;
        int b = 2 * k;

        if (b > a) return 0;

        long x = 1;
        long y = 1;

        for (int i = 1; i <= b; i++) {
            x = x * (a - b + i) % mod;
            y = y * i % mod;
        }

        return (int)(x * pow(y, mod - 2, mod) % mod);
    }

    private long pow(long a, long b, long m) {
        long r = 1;

        while (b > 0) {
            if ((b & 1) != 0) {
                r = r * a % m;
            }
            a = a * a % m;
            b >>= 1;
        }

        return r;
    }
}