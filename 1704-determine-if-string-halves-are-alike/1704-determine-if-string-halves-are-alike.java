class Solution {
    public boolean halvesAreAlike(String s) {
        int a = 0, b = 0;
        int n = s.length();

        for (int i = 0; i < n / 2; i++) {
            char x = s.charAt(i);
            char y = s.charAt(i + n / 2);

            if ("aeiouAEIOU".indexOf(x) >= 0) a++;
            if ("aeiouAEIOU".indexOf(y) >= 0) b++;
        }

        return a == b;
    }
}