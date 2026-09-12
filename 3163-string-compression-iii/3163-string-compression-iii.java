class Solution {
    public String compressedString(String word) {
        StringBuilder q = new StringBuilder();
        int x = 0;

        while (x < word.length()) {
            char y = word.charAt(x);
            int z = 0;

            while (x < word.length() && word.charAt(x) == y && z < 9) {
                x++;
                z++;
            }

            q.append(z).append(y);
        }

        return q.toString();
    }
}