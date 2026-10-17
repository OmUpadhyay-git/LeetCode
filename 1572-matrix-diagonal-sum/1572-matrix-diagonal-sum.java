class Solution {
  public int diagonalSum(int[][]
  
  git) {
    final int n =
    
    git.length;
    int ans = 0;

    for (int i = 0; i < n; ++i) {
      ans +=
      
      git[i][i];
      ans +=
      
      git[n - 1 - i][i];
    }

    return n % 2 == 0 ? ans : ans -
    
    git[n / 2][n / 2];
  }
}