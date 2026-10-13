
import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[] arr = new long[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = Math.abs((long) nums[i]);
        }

        Arrays.sort(arr);

        long ans = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            long x = arr[i] * arr[i];
            ans += i < n / 2 ? -x : x;
        }

        return ans;
    }
}
