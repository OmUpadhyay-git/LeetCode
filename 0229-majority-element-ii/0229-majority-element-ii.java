class Solution {
    public java.util.List<Integer> majorityElement(int[] nums) {
        java.util.List<Integer> z = new java.util.ArrayList<>();

        int p = 0, q = 1;
        int a = 0, b = 0;

        for (int v : nums) {
            if (v == p) {
                a++;
            } else if (v == q) {
                b++;
            } else if (a == 0) {
                p = v;
                a = 1;
            } else if (b == 0) {
                q = v;
                b = 1;
            } else {
                a--;
                b--;
            }
        }

        a = 0;
        b = 0;

        for (int v : nums) {
            if (v == p) a++;
            else if (v == q) b++;
        }

        int t = nums.length / 3;

        if (a > t) z.add(p);
        if (b > t) z.add(q);

        return z;
    }
}