class Solution {
    public int scoreOfParentheses(String s) {
        int a = 0;
        int b = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                b++;
            } else {
                b--;
                if (s.charAt(i - 1) == '(') {
                    a += 1 << b;
                }
            }
        }

        return a;
    }
}