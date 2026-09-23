class Solution {
    public int buyChoco(int[] prices, int money) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;

        for (int v : prices) {
            if (v < a) {
                b = a;
                a = v;
            } else if (v < b) {
                b = v;
            }
        }

        int c = a + b;
        return c <= money ? money - c : money;
    }
}