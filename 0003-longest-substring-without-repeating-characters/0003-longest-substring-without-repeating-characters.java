class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] a = new int[128];
        int b = 0, c = 0, d = 0;

        for (int e = 0; e < s.length(); e++) {
            int f = s.charAt(e);

            if (a[f] > b) {
                b = a[f];
            }

            a[f] = e + 1;
            d = Math.max(d, e - b + 1);
        }

        return d;
    }
}