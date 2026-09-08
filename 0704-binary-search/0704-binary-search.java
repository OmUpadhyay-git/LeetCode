class Solution {
    public int search(int[] nums, int target) {
        int a = 0, b = nums.length - 1;

        while (a <= b) {
            int c = a + (b - a) / 2;

            if (nums[c] == target) {
                return c;
            } else if (nums[c] < target) {
                a = c + 1;
            } else {
                b = c - 1;
            }
        }

        return -1;
    }
}