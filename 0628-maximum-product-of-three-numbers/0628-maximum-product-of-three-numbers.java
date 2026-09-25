class Solution {
    public int maximumProduct(int[] nums) {
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;

        for (int z : nums) {
            if (z >= a) {
                c = b;
                b = a;
                a = z;
            } else if (z >= b) {
                c = b;
                b = z;
            } else if (z > c) {
                c = z;
            }

            if (z <= x) {
                y = x;
                x = z;
            } else if (z < y) {
                y = z;
            }
        }

        return Math.max(a * b * c, a * x * y);
    }
}