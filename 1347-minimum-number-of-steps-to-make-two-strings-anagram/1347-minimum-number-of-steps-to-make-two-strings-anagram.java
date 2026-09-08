class Solution {
    public int minSteps(String s, String t) {
        int[] a = new int[26];

        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
            a[t.charAt(i) - 'a']--;
        }

        int b = 0;

        for (int x : a) {
            if (x < 0) {
                b -= x;
            }
        }

        return b;
    }
}