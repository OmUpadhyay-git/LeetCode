class Solution {
    public int smallestIndex(int[] nums) {
        for (int z = 0; z < nums.length; z++) {
            int q = nums[z];
            int r = 0;

            while (q > 0) {
                r += q % 10;
                q /= 10;
            }

            if (r == z) {
                return z;
            }
        }

        return -1;
    }
}