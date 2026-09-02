class Solution {
    public boolean checkIfPangram(String sentence) {
        String sample = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < sample.length(); i++) {
            if (sentence.indexOf(sample.charAt(i)) == -1) {
                return false;
            }
        }

        return true;
    }
}