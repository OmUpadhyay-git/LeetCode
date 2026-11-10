class Solution {
    public int climbStairs(int n, int[] costs) {
        int a = Integer.MAX_VALUE / 2;
        int b = Integer.MAX_VALUE / 2;
        int c = 0;

        for (int i = 1; i <= n; i++) {
            int d = costs[i - 1] + Math.min(
                c + 1,
                Math.min(b + 4, a + 9)
            );

            a = b;
            b = c;
            c = d;
        }

        return c;
    }
}
