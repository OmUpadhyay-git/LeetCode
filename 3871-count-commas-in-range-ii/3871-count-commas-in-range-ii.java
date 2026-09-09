class Solution {
    public long countCommas(long z) {
        long q = 1000;
        long r = 0;

        while (q <= z) {
            r += z - q + 1;
            if (q > z / 1000) break;
            q *= 1000;
        }

        return r;
    }
}