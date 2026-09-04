class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        int suffixMin = nums[n - 1];
        int[] min = new int[n];

        // Build suffix minimums
        for (int i = n - 1; i >= 0; i--) {
            suffixMin = Math.min(suffixMin, nums[i]);
            min[i] = suffixMin;
        }

        int prefixMax = nums[0];

        for (int i = 0; i < n; i++) {
            prefixMax = Math.max(prefixMax, nums[i]);

            if (prefixMax - min[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}