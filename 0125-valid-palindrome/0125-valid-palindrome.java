class Solution {
    public boolean isPalindrome(String s) {
        int x = 0, y = s.length() - 1;

        while (x < y) {
            while (x < y && !Character.isLetterOrDigit(s.charAt(x))) x++;
            while (x < y && !Character.isLetterOrDigit(s.charAt(y))) y--;

            if (Character.toLowerCase(s.charAt(x)) != Character.toLowerCase(s.charAt(y))) {
                return false;
            }

            x++;
            y--;
        }

        return true;
    }
}