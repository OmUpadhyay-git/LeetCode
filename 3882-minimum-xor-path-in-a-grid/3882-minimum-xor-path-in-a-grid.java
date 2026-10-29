import java.util.*;

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Set<Integer>[][] dp = new HashSet[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new HashSet<>();
            }
        }

        dp[0][0].add(grid[0][0]);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int val : dp[i][j]) {
                    if (j + 1 < n) {
                        dp[i][j + 1].add(val ^ grid[i][j + 1]);
                    }

                    if (i + 1 < m) {
                        dp[i + 1][j].add(val ^ grid[i + 1][j]);
                    }
                }
            }
        }

        return Collections.min(dp[m - 1][n - 1]);
    }
}