class Solution {
    public boolean checkIfPangram(String atc) {
        boolean[] seen = new boolean[26];

        for (char ch : atc.toCharArray()) {
            seen[ch - 'a'] = true;
        }

        for (boolean abc : seen) {
            if (!abc) {
                return false;
            }
        }

        return true;
    }
}