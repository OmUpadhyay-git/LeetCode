class Solution {
    public int majorityElement(int[] nums) {
        int a = 0;
        int b = 0;

        for (int x : nums) {
            if (b == 0) {
                a = x;
            }
            b += (x == a) ? 1 : -1;
        }

        return a;
    }
}