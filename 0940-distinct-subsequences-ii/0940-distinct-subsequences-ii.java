class Solution {
    public int distinctSubseqII(String s) {
        final long MOD = 1_000_000_007L;
        long[] last = new long[26];
        long dp = 1;

        for (char c : s.toCharArray()) {
            int i = c - 'a';
            long next = (2 * dp % MOD - last[i] + MOD) % MOD;
            last[i] = dp;
            dp = next;
        }

        return (int) ((dp - 1 + MOD) % MOD);
    }
}