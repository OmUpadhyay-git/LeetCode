class Solution {
    public int largestRectangleArea(int[] a) {
        int n = a.length;
        int[] b = new int[n + 1];
        System.arraycopy(a, 0, b, 0, n);

        int[] s = new int[n + 1];
        int t = -1;
        int r = 0;

        for (int i = 0; i <= n; i++) {
            while (t >= 0 && b[s[t]] > b[i]) {
                int h = b[s[t--]];
                int w = t < 0 ? i : i - s[t] - 1;
                r = Math.max(r, h * w);
            }
            s[++t] = i;
        }

        return r;
    }
}