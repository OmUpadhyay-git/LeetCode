class Solution {
    public boolean detectCapitalUse(String word) {
        int q = 0;
        
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                q++;
            }
        }
        
        return q == 0 || q == word.length() || 
               (q == 1 && Character.isUpperCase(word.charAt(0)));
    }
}