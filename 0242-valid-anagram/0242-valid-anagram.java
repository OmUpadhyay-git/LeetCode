class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] q = new int[26];

        for (int i = 0; i < s.length(); i++) {
            q[s.charAt(i) - 'a']++;
            q[t.charAt(i) - 'a']--;
        }

        for (int x : q) {
            if (x != 0) {
                return false;
            }
        }

        return true;
    }
}