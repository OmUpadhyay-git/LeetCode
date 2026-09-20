class Solution {
    public int maxProfit(int[] q) {
        int a = q[0], b = 0;

        for (int i = 1; i < q.length; i++) {
            a = Math.min(a, q[i]);
            b = Math.max(b, q[i] - a);
        }

        return b;
    }
}