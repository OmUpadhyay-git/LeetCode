
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int p = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                p = i;
                break;
            }
        }

        boolean a = true;
        boolean b = true;

        for (int i = 0; i < n; i++) {
            if (nums[(p + i) % n] != i) a = false;
            if (nums[(p - i + n) % n] != i) b = false;
        }

        if (a) return Math.min(p, n - p + 2);
        if (b) return 1 + Math.min((p + 1) % n, (n - p - 1 + n) % n);

        return -1;
    }
}
