class Solution {
    public String makeGood(String opss) {
        char[] sta = new char[opss.length()];
        int top = 0;

        for (char mp : opss.toCharArray()) {
            if (top > 0 && Math.abs(sta[top - 1] - mp) == 32) {
                top--; 
            } else {
                sta[top++] = mp;
            }
        }

        return new String(sta, 0, top);
    }
}
