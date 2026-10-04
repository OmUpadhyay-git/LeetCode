
class Solution {
    public boolean checkValidString(String s) {
        int a = 0, b = 0;

        for (int c = 0; c < s.length(); c++) {
            char d = s.charAt(c);

            if (d == '(') {
                a++;
                b++;
            } else if (d == ')') {
                a--;
                b--;
            } else {
                a--;
                b++;
            }

            if (b < 0) {
                return false;
            }

            if (a < 0) {
                a = 0;
            }
        }

        return a == 0;
    }
}
