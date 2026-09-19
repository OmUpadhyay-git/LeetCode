class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        long a = Math.max(x1, Math.min(xCenter, x2));
        long b = Math.max(y1, Math.min(yCenter, y2));

        long p = a - xCenter;
        long q = b - yCenter;

        return p * p + q * q <= (long) radius * radius;
    }
}