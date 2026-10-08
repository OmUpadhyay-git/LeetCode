import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> z = new ArrayList<>();
        g(s, 0, 0, new char[]{'(', ')'}, z);
        return z;
    }

    private void g(String s, int a, int b, char[] c, List<String> d) {
        int e = 0;

        for (int f = a; f < s.length(); f++) {
            char h = s.charAt(f);

            if (h == c[0]) {
                e++;
            } else if (h == c[1]) {
                e--;
            }

            if (e >= 0) {
                continue;
            }

            for (int i = b; i <= f; i++) {
                if (s.charAt(i) == c[1] &&
                    (i == b || s.charAt(i - 1) != c[1])) {
                    g(
                        s.substring(0, i) + s.substring(i + 1),
                        f,
                        i,
                        c,
                        d
                    );
                }
            }

            return;
        }

        String j = new StringBuilder(s).reverse().toString();

        if (c[0] == '(') {
            g(j, 0, 0, new char[]{')', '('}, d);
        } else {
            d.add(j);
        }
    }
}