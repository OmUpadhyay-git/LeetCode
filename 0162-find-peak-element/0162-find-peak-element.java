class Solution {
    public int findPeakElement(int[] x) {
        int a = 0, b = x.length - 1;

        while (a < b) {
            int c = a + (b - a) / 2;

            if (x[c] > x[c + 1]) {
                b = c;
            } else {
                a = c + 1;
            }
        }

        return a;
    }
}