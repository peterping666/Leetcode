public class _498_DiagonalTraverse {
    /**
     * Time O(m * n)
     * Space O(1)
     * @param matrix
     * @return
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return new int[0];
        int m = matrix.length, n = matrix[0].length;
        int[] res = new int[m * n];
        int[][] dirs = {{-1, 1}, {1, -1}};
        int r = 0, c = 0, d = 0;
        for(int i = 0; i < m * n; i++) {
            res[i] = matrix[r][c];
            r += dirs[d][0];
            c += dirs[d][1];
            if(r >= m) {
                r = m - 1;
                c += 2;
                d = 1 - d;
            }
            if(c >= n) {
                c = n - 1;
                r += 2;
                d = 1 - d;
            }
            if(r < 0) {
                r = 0;
                d = 1 - d;
            }
            if(c < 0) {
                c = 0;
                d = 1 - d;
            }
        }
        return res;
    }
}
