class Solution {
    int z = 0;

    public int averageOfSubtree(TreeNode q) {
        r(q);
        return z;
    }

    private long r(TreeNode q) {
        if (q == null) return 0;

        long a = r(q.left);
        long b = r(q.right);

        long c = a >> 32;
        long d = a & 0xffffffffL;
        long e = b >> 32;
        long f = b & 0xffffffffL;

        long g = c + e + q.val;
        long h = d + f + 1;

        if (q.val == g / h) z++;

        return (g << 32) | h;
    }
}