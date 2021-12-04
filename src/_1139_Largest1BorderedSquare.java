public class _1139_Largest1BorderedSquare {
    class Solution {
        public int largest1BorderedSquare(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[][] hor = new int[m][n];
            int[][] ver = new int[m][n];
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] == 1) {
                        hor[i][j] = j == 0 ? 1 : hor[i][j-1] + 1;
                        ver[i][j] = i == 0 ? 1 : ver[i-1][j] + 1;
                    }
                }
            }
            int res = 0;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    int len = Math.min(hor[i][j], ver[i][j]);
                    while(len > res) {
                        if(hor[i-len+1][j] >= len && ver[i][j-len+1] >= len) {
                            res = len;
                        }
                        len--;
                    }
                }
            }
            return res * res;
        }
    }
}
