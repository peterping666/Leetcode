public class _329_LongestIncreasingPathinaMatrix {
    /**
     * Time O(m * n)
     * Space O(m * n)
     * @param matrix
     * @return
     */
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] cache = new int[n][m];
        int maxLen = -1;
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                maxLen = Math.max(maxLen, dfs(matrix, i, j, n, m, cache, dirs));
            }
        }
        return maxLen;
    }

    private int dfs(int[][] matrix, int i, int j, int n, int m, int[][] cache, int[][] dirs) {
        if(cache[i][j] != 0) return cache[i][j];
        int len = 1;
        for(int[] dir : dirs) {
            int curLen = 1;
            int x = i + dir[0];
            int y = j + dir[1];
            if(x >= 0 && x < n && y >= 0 && y < m && matrix[x][y] > matrix[i][j]) {
                curLen += dfs(matrix, x, y, n, m, cache, dirs);
            }
            len = Math.max(len, curLen);
        }
        cache[i][j] = len;
        return len;
    }
}
