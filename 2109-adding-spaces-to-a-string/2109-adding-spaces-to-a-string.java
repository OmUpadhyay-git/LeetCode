class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder x = new StringBuilder(s.length() + spaces.length);
        int y = 0;

        for (int z = 0; z < s.length(); z++) {
            if (y < spaces.length && z == spaces[y]) {
                x.append(' ');
                y++;
            }
            x.append(s.charAt(z));
        }

        return x.toString();
    }
}