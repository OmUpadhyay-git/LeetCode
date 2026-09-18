import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> a = new HashMap<>();
        a.put(0, 1);

        int b = 0;
        int c = 0;

        for (int x : nums) {
            b += x;
            c += a.getOrDefault(b - k, 0);
            a.put(b, a.getOrDefault(b, 0) + 1);
        }

        return c;
    }
}