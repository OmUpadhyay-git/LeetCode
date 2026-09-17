class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] z = new int[n];
        int q = n + 1;
        int a = 0;
        int b = 0;
        int c = 0;
        int d = q;

        for (int i = 0; i < n; i++) {
            z[i] = q;
        }

        while (b < n) {
            c += arr[b];

            while (a <= b && c > target) {
                c -= arr[a++];
            }

            if (c == target) {
                int e = b - a + 1;

                if (a > 0 && z[a - 1] != q) {
                    d = Math.min(d, e + z[a - 1]);
                }

                z[b] = e;
            }

            if (b > 0) {
                z[b] = Math.min(z[b], z[b - 1]);
            }

            b++;
        }

        return d == q ? -1 : d;
    }
}