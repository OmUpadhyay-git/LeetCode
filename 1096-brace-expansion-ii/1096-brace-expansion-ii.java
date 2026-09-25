class Solution {
    private int[] z;

    public java.util.List<String> braceExpansionII(String x) {
        z = new int[]{0};
        java.util.Set<String> a = f(x);
        java.util.List<String> b = new java.util.ArrayList<>(a);
        java.util.Collections.sort(b);
        return b;
    }

    private java.util.Set<String> f(String x) {
        java.util.Set<String> a = new java.util.HashSet<>();
        a.add("");

        while (z[0] < x.length() && x.charAt(z[0]) != '}' && x.charAt(z[0]) != ',') {
            java.util.Set<String> b;

            if (x.charAt(z[0]) == '{') {
                z[0]++;
                b = new java.util.HashSet<>();

                while (true) {
                    b.addAll(f(x));

                    if (x.charAt(z[0]) == '}') {
                        z[0]++;
                        break;
                    }

                    z[0]++;
                }
            } else {
                b = new java.util.HashSet<>();
                b.add(String.valueOf(x.charAt(z[0]++)));
            }

            java.util.Set<String> c = new java.util.HashSet<>();

            for (String p : a) {
                for (String q : b) {
                    c.add(p + q);
                }
            }

            a = c;
        }

        return a;
    }
}