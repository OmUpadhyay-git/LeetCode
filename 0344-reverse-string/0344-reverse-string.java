class Solution {
    public void reverseString(char[] sp) {
        int l = 0;
        int r = sp.length - 1;

        while (l < r) {
            char temp = sp[l];
            sp[l] = sp[r];
            sp[r] = temp;

            l++;
            r--;
        }
    }
}