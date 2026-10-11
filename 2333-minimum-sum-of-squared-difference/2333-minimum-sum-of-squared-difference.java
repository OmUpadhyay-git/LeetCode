class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] d = new int[n];
        int mx = 0;
        for (int i = 0; i < n; i++) {
            d[i] = Math.abs(nums1[i] - nums2[i]);
            mx = Math.max(mx, d[i]);
        }
        long K = (long)k1 + k2;
        int lo = 0, hi = mx;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            long ops = 0;
            for (int x : d) {
                if (x > mid) {
                    ops += (x - mid);
                    if (ops > K) break;
                }
            }
            if (ops <= K) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        int T = lo;
        long used = 0, cnt = 0, ans = 0;
        for (int x : d) {
            if (x > T) {
                used += (x - T);
                cnt++;
                ans += (long)T * T;
            } else if (x == T) {
                cnt++;
                ans += (long)T * T;
            } else {
                ans += (long)x * x;
            }
        }
        long rem = K - used;
        long dec = Math.min(rem, cnt);
        if (T > 0) {
            ans -= dec * (2L * T - 1);
        }
        return ans;
    }
}