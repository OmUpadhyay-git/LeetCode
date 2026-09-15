class Solution {
    public long countSubstrings(String s, char c) {
        long a = 0;
        long b = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                a++;
                b += a;
            }
        }

        return b;
    }
}