class Solution {
    public int minMoves(int[] nums) {
        int a = nums[0];
        int b = 0;

        for (int c : nums) {
            if (c < a) {
                a = c;
            }
        }

        for (int c : nums) {
            b += c - a;
        }

        return b;
    }
}