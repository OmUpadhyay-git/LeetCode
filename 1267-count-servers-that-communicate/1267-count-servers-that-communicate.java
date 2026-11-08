
class Solution {
    public int countServers(int[][] grid) {
        int p = grid.length;
        int q = grid[0].length;

        int[] r = new int[p];
        int[] s = new int[q];

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                if (grid[i][j] == 1) {
                    r[i]++;
                    s[j]++;
                }
            }
        }

        int t = 0;

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                if (grid[i][j] == 1 && (r[i] > 1 || s[j] > 1)) {
                    t++;
                }
            }
        }

        return t;
    }
}
