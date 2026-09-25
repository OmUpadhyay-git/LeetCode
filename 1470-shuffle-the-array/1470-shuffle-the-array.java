class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] q = new int[2 * n];
        int r = 0;

        for (int i = 0; i < n; i++) {
            q[r++] = nums[i];
            q[r++] = nums[i + n];
        }

        return q;
    }
}