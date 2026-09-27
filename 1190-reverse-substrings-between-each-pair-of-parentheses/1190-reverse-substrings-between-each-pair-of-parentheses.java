class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        char[] a = s.toCharArray();
        int[] b = new int[n];
        int[] c = new int[n];
        int d = 0;

        for (int e = 0; e < n; e++) {
            if (a[e] == '(') {
                c[d++] = e;
            } else if (a[e] == ')') {
                int f = c[--d];
                b[e] = f;
                b[f] = e;
            }
        }

        StringBuilder g = new StringBuilder();
        int h = 0;
        int i = 1;

        while (h < n) {
            if (a[h] == '(' || a[h] == ')') {
                h = b[h];
                i = -i;
            } else {
                g.append(a[h]);
            }
            h += i;
        }

        return g.toString();
    }
}