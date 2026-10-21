
class Solution {
    public int minOperations(String s) {
        int n = s.length();
        boolean a = true;
        char b = s.charAt(0);
        char c = s.charAt(n - 1);
        char d = b;
        char e = b;
        int f = 0;
        int g = 0;

        for (int i = 0; i < n; i++) {
            char h = s.charAt(i);

            if (i > 0 && s.charAt(i - 1) > h) {
                a = false;
            }

            if (h < d) d = h;
            if (h > e) e = h;
            if (h == b) f++;
            if (h == c) g++;
        }

        if (a) return 0;
        if (n == 2) return -1;
        if (b == d || c == e) return 1;
        if (b == e && c == d && f == 1 && g == 1) return 3;

        return 2;
    }
}
