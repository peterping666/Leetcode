public class _329_LongestIncreasingPathinaMatrix {
    /**
     * Time O(m * n)
     * Space O(m * n)
     */
    class Solution {
        public int longestIncreasingPath(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int res = 0;
            int[][] memo = new int[m][n];

            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    res = Math.max(res, helper(matrix, i, j, m, n, memo));
                }
            }
            return res;
        }

        private int helper(int[][] matrix, int i, int j, int m, int n, int[][] memo) {
            if(memo[i][j] != 0) {
                return memo[i][j];
            }

            int len = 0;
            int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
            for(int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) {
                    continue;
                }
                len = Math.max(len, helper(matrix, x, y, m, n, memo));
            }
            memo[i][j] = len + 1;
            return len + 1;
        }
    }
}
