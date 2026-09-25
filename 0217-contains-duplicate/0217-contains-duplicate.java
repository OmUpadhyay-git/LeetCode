class Solution {
    public boolean containsDuplicate(int[] nums) {
        java.util.HashSet<Integer> q = new java.util.HashSet<>();

        for (int x : nums) {
            if (!q.add(x)) {
                return true;
            }
        }

        return false;
    }
}