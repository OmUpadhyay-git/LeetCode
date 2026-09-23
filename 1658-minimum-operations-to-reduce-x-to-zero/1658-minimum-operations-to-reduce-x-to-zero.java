class Solution {
    public int minOperations(int[] nums, int x) {
        int z = 0;
        for (int v : nums) z += v;

        int q = z - x;
        if (q < 0) return -1;

        int a = 0, b = 0, c = 0, d = -1;

        while (b < nums.length) {
            c += nums[b++];

            while (c > q && a < b) {
                c -= nums[a++];
            }

            if (c == q) {
                d = Math.max(d, b - a);
            }
        }

        return d == -1 ? -1 : nums.length - d;
    }
}