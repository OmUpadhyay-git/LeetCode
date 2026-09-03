class Solution {
    public boolean uniformArray(int[] nums) {
         int minOdd = Integer.MAX_VALUE;

        for (int x : nums) {
            if ((x & 1) == 1) {
                minOdd = Math.min(minOdd, x);
            }
        }

        if (minOdd == Integer.MAX_VALUE) return true;

        for (int x : nums) {
            if ((x & 1) == 0 && x < minOdd) {
                return false;
            }
        }

        return true;
    }
}