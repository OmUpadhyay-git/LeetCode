class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] z = new int[n];

        int a = 1;
        for (int i = 0; i < n; i++) {
            z[i] = a;
            a *= nums[i];
        }

        int b = 1;
        for (int i = n - 1; i >= 0; i--) {
            z[i] *= b;
            b *= nums[i];
        }

        return z;
    }
}