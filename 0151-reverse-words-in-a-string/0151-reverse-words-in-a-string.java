class Solution {
    public String reverseWords(String s) {
        StringBuilder a = new StringBuilder();
        int b = s.length() - 1;

        while (b >= 0) {
            while (b >= 0 && s.charAt(b) == ' ') {
                b--;
            }

            if (b < 0) {
                break;
            }

            int c = b;

            while (b >= 0 && s.charAt(b) != ' ') {
                b--;
            }

            if (a.length() > 0) {
                a.append(' ');
            }

            a.append(s, b + 1, c + 1);
        }

        return a.toString();
    }
}