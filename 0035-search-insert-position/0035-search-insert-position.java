class Solution {
    public int searchInsert(int[] q, int z) {
        int a = 0, b = q.length;

        while (a < b) {
            int c = a + (b - a) / 2;

            if (q[c] < z) {
                a = c + 1;
            } else {
                b = c;
            }
        }

        return a;
    }
}