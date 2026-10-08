class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int[] a = nums1;
        int[] b = nums2;
        int x = a.length;
        int y = b.length;
        int z = (x + y + 1) / 2;

        int p = 0;
        int q = x;

        while (p <= q) {
            int r = (p + q) / 2;
            int s = z - r;

            int u = r == 0 ? Integer.MIN_VALUE : a[r - 1];
            int v = s == 0 ? Integer.MIN_VALUE : b[s - 1];
            int w = r == x ? Integer.MAX_VALUE : a[r];
            int t = s == y ? Integer.MAX_VALUE : b[s];

            if (u <= t && v <= w) {
                if ((x + y) % 2 == 1) {
                    return Math.max(u, v);
                }

                return ((double) Math.max(u, v) + Math.min(w, t)) / 2.0;
            }

            if (u > t) {
                q = r - 1;
            } else {
                p = r + 1;
            }
        }

        return 0.0;
    }
}