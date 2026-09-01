import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int sr = 0, sc = 0;
        int litterCount = 0;

        // Assign each litter a bit.
        int[][] id = new int[m][n];
        for (int[] row : id) {
            Arrays.fill(row, -1);
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                char ch = classroom[r].charAt(c);

                if (ch == 'S') {
                    sr = r;
                    sc = c;
                } else if (ch == 'L') {
                    id[r][c] = litterCount++;
                }
            }
        }

        if (litterCount == 0) {
            return 0;
        }

        int totalMask = (1 << litterCount) - 1;

        /*
         * best[r][c][mask] = maximum energy with which
         * we have reached (r,c) having collected 'mask'.
         *
         * If a new state has energy <= best[r][c][mask],
         * it can be discarded.
         */
        int[][][] best = new int[m][n][1 << litterCount];

        for (int[][] row : best) {
            for (int[] x : row) {
                Arrays.fill(x, -1);
            }
        }

        // State: r, c, remainingEnergy, mask
        ArrayDeque<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{sr, sc, energy, 0});
        best[sr][sc][0] = energy;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] cur = q.poll();

                int r = cur[0];
                int c = cur[1];
                int e = cur[2];
                int mask = cur[3];

                if (mask == totalMask) {
                    return moves;
                }

                if (e == 0) {
                    continue;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }

                    char cell = classroom[nr].charAt(nc);

                    if (cell == 'X') {
                        continue;
                    }

                    int ne = e - 1;
                    int nmask = mask;

                    // Reset energy.
                    if (cell == 'R') {
                        ne = energy;
                    }

                    // Collect litter.
                    if (cell == 'L') {
                        nmask |= 1 << id[nr][nc];
                    }

                    // Dominance pruning.
                    if (ne <= best[nr][nc][nmask]) {
                        continue;
                    }

                    best[nr][nc][nmask] = ne;
                    q.offer(new int[]{nr, nc, ne, nmask});
                }
            }

            moves++;
        }

        return -1;
    }
}