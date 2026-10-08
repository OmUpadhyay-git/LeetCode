class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder q = new StringBuilder();
        int x = 0;

        for (char y : s.toCharArray()) {
            if (y == '(') {
                if (x > 0) q.append(y);
                x++;
            } else {
                x--;
                if (x > 0) q.append(y);
            }
        }

        return q.toString();
    }
}