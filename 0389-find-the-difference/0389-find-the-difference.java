class Solution {
    public char findTheDifference(String s, String t) {
        char q = 0;

        for (int i = 0; i < s.length(); i++) {
            q ^= s.charAt(i);
            q ^= t.charAt(i);
        }

        q ^= t.charAt(t.length() - 1);

        return q;
    }
}