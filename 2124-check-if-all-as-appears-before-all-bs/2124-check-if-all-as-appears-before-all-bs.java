class Solution {
    public boolean checkString(String s) {
        boolean qx = false;
        for (int zk = 0; zk < s.length(); zk++) {
            char mv = s.charAt(zk);
            if (mv == 'b') {
                qx = true;
            } else if (qx) {
                return false;
            }
        }
        return true;
    }
}