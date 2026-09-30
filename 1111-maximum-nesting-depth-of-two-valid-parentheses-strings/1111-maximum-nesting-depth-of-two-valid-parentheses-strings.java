class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] x = new int[seq.length()];
        int y = 0;

        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                y++;
                x[i] = y % 2;
            } else {
                x[i] = y % 2;
                y--;
            }
        }

        return x;
    }
}