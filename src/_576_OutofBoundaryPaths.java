public class _576_OutofBoundaryPaths {

    class Solution1 {
        public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
            int[][] dp = new int[m][n];
            dp[startRow][startColumn] = 1;
            int res = 0, mod = (int)(1e9+7);
            int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
            for(int k = 0; k < maxMove; k++) {
                int[][] temp = new int[m][n];
                for(int i = 0; i < m; i++) {
                    for(int j = 0; j < n; j++) {
                        for(int[] dir : dirs) {
                            int x = dir[0] + i;
                            int y = dir[1] + j;
                            if(x < 0 || x >= m || y < 0 || y >= n) {
                                res = (res + dp[i][j]) % mod;
                            } else {
                                temp[x][y] = (temp[x][y] + dp[i][j]) % mod;
                            }
                        }
                    }
                }
                dp = temp;
            }
            return res;
        }
    }

    class Solution2 {
        public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
            return dfs(m, n, maxMove, startRow, startColumn, new int[maxMove + 1][m][n]);
        }

        private int dfs(int m, int n, int k, int i, int j, int[][][] dp) {
            if(i < 0 || i >= m || j < 0 || j >= n) {
                return 1;
            }
            if(k == 0) {
                return 0;
            }
            if(dp[k][i][j] != 0) {
                return dp[k][i][j];
            }
            int mod = (int)(1e9 + 7);
            int res = dfs(m, n, k-1, i-1, j, dp);
            res = (res + dfs(m, n, k-1, i+1, j, dp)) % mod;
            res = (res + dfs(m, n, k-1, i, j-1, dp)) % mod;
            res = (res + dfs(m, n, k-1, i, j+1, dp)) % mod;
            dp[k][i][j] = res;
            return res;
        }
    }
}
