class Solution {
    public int lengthOfLastWord(String x) {
        int a = x.length() - 1;
        
        while (a >= 0 && x.charAt(a) == ' ') {
            a--;
        }
        
        int b = 0;
        
        while (a >= 0 && x.charAt(a) != ' ') {
            b++;
            a--;
        }
        
        return b;
    }
}