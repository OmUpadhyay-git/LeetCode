class Solution {
    public int maxSubArray(int[] nums) {
        int x = nums[0];
        int y = nums[0];

        for (int i = 1; i < nums.length; i++) {
            x = Math.max(nums[i], x + nums[i]);
            y = Math.max(y, x);
        }

        return y;
    }
}