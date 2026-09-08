class Solution {
    public int compress(char[] chars) {
        int a = 0, b = 0;

        while (b < chars.length) {
            char x = chars[b];
            int c = 0;

            while (b < chars.length && chars[b] == x) {
                b++;
                c++;
            }

            chars[a++] = x;

            if (c > 1) {
                int d = b;
                int e = c;

                while (e > 0) {
                    chars[--d] = (char) ('0' + e % 10);
                    e /= 10;
                }

                while (d < b) {
                    chars[a++] = chars[d++];
                }
            }
        }

        return a;
    }
}