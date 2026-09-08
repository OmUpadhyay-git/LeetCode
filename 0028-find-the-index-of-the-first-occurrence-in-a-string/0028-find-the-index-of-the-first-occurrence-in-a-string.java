class Solution {
    public int strStr(String haystack, String needle) {
        int[] z = new int[needle.length()];
        int a = 0;

        for (int b = 1; b < needle.length(); b++) {
            while (a > 0 && needle.charAt(a) != needle.charAt(b)) {
                a = z[a - 1];
            }
            if (needle.charAt(a) == needle.charAt(b)) {
                a++;
            }
            z[b] = a;
        }

        a = 0;

        for (int b = 0; b < haystack.length(); b++) {
            while (a > 0 && haystack.charAt(b) != needle.charAt(a)) {
                a = z[a - 1];
            }
            if (haystack.charAt(b) == needle.charAt(a)) {
                a++;
            }
            if (a == needle.length()) {
                return b - a + 1;
            }
        }

        return -1;
    }
}