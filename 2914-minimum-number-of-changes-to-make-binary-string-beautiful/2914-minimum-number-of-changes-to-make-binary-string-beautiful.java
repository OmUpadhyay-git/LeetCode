
class Solution {
    public int minChanges(String s) {
        int q = 0;

        for (int z = 0; z < s.length(); z += 2) {
            if (s.charAt(z) != s.charAt(z + 1)) {
                q++;
            }
        }

        return q;
    }
}
