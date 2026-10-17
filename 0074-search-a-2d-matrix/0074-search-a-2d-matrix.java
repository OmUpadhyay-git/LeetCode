class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int a = matrix.length;
        int b = matrix[0].length;
        int c = 0;
        int d = a * b - 1;

        while (c <= d) {
            int e = c + (d - c) / 2;
            int f = matrix[e / b][e % b];

            if (f == target) return true;
            if (f < target) c = e + 1;
            else d = e - 1;
        }

        return false;
    }
}