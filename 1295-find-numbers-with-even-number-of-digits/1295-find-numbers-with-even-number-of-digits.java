class Solution {
    public int findNumbers(int[] nums) {
        int total = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int digits = 0;

            while (num != 0) {
                num /= 10;
                digits++;
            }

            if (digits % 2 == 0) {
                total++;
            }
        }

        return total;
    }
}