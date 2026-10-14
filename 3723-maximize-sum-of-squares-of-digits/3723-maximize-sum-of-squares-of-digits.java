class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num || (sum == 0 && num > 1)) return "";
        if (sum == 0) return "0";

        StringBuilder a = new StringBuilder();

        for (int i = 0; i < num; i++) {
            int b = Math.min(9, sum);
            a.append(b);
            sum -= b;
        }

        return sum == 0 ? a.toString() : "";
    }
}