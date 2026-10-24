
class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] a = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int b = f(arriveAlice, a);
        int c = f(leaveAlice, a);
        int d = f(arriveBob, a);
        int e = f(leaveBob, a);

        return Math.max(0, Math.min(c, e) - Math.max(b, d) + 1);
    }

    private int f(String s, int[] a) {
        int x = Integer.parseInt(s.substring(0, 2));
        int y = Integer.parseInt(s.substring(3, 5));
        int z = y;

        for (int i = 0; i < x - 1; i++) {
            z += a[i];
        }

        return z;
    }
}
