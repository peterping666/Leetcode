public class _1219_PathwithMaximumGold {
    class Solution {
        public int getMaximumGold(int[][] grid) {
            int res = 0;
            int m = grid.length;
            int n = grid[0].length;
            int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] != 0) {
                        res = Math.max(res, helper(grid, i, j, dirs));
                    }
                }
            }
            return res;
        }

        private int helper(int[][] grid, int i, int j, int[][] dirs) {
            if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
                return 0;
            }
            int origin = grid[i][j];
            grid[i][j] = 0;
            int res = 0;
            for(int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                res = Math.max(res, helper(grid, x, y, dirs));
            }
            grid[i][j] = origin;
            return res + origin;
        }
    }
}
