class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int x = 0, y = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[x]) x = i;
            if (nums[i] > nums[y]) y = i;
        }

        int a = Math.min(x, y);
        int b = Math.max(x, y);

        return Math.min(
            Math.min(b + 1, n - a),
            a + 1 + n - b
        );
    }
}