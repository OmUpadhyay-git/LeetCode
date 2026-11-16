
class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder a = new StringBuilder();

            for (int i = 0; i < s.length(); i += k) {
                int b = 0;

                for (int j = i; j < Math.min(i + k, s.length()); j++) {
                    b += s.charAt(j) - '0';
                }

                a.append(b);
            }

            s = a.toString();
        }

        return s;
    }
}
