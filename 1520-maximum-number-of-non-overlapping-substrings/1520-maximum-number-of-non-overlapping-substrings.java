import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int[] q = new int[26];
        int[] w = new int[26];
        Arrays.fill(q, -1);

        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - 'a';
            if (q[x] == -1) q[x] = i;
            w[x] = i;
        }

        List<int[]> z = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            if (q[i] == -1) continue;

            int a = q[i];
            int b = w[i];
            boolean ok = true;

            for (int j = a; j <= b; j++) {
                int x = s.charAt(j) - 'a';

                if (q[x] < a) {
                    ok = false;
                    break;
                }

                b = Math.max(b, w[x]);
            }

            if (ok) z.add(new int[]{a, b});
        }

        z.sort((x, y) -> Integer.compare(x[1], y[1]));

        List<String> ans = new ArrayList<>();
        int p = -1;

        for (int[] v : z) {
            if (v[0] > p) {
                ans.add(s.substring(v[0], v[1] + 1));
                p = v[1];
            }
        }

        return ans;
    }
}