class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] seen = new boolean[26];

        for (char ch : sentence.toCharArray()) {
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