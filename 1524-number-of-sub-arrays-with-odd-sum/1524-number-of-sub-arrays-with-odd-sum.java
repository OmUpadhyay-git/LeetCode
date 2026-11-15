
class Solution {
    public int numOfSubarrays(int[] arr) {
        long c = 0;
        int a = 1, b = 0;
        int d = 0;
        int m = 1000000007;

        for (int x : arr) {
            d = (d + x) % 2;

            if (d == 1) {
                c = (c + a) % m;
                b++;
            } else {
                c = (c + b) % m;
                a++;
            }
        }

        return (int) c;
    }
}
