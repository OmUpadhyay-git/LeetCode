class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth,
                            int need1, int need2) {

        return Math.min(
            Math.min(
                (long) need1 * cost1 + (long) need2 * cost2,

                (long) Math.min(need1, need2) * costBoth
                    + (long) Math.abs(need1 - need2)
                    * (need1 > need2 ? cost1 : cost2)
            ),

            (long) Math.max(need1, need2) * costBoth
        );
    }
}