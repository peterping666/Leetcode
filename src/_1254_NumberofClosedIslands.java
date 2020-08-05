public class _1254_NumberofClosedIslands {
    class Solution {
        public int closedIsland(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int res = 0;
            boolean[][] visited = new boolean[m][n];
            int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(!visited[i][j] && grid[i][j] == 0) {
                        if(helper(grid, i, j, visited, dirs)) {
                            res++;
                        }
                    }
                }
            }
            return res;
        }

        private boolean helper(int[][] grid, int i, int j, boolean[][] visited, int[][] dirs) {
            if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
                return false;
            }
            if(visited[i][j] || grid[i][j] == 1) {
                return true;
            }
            visited[i][j] = true;
            boolean isSurrounded = true;
            for(int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                if(!helper(grid, x, y, visited, dirs)) {
                    isSurrounded = false;
                }
            }
            return isSurrounded;
        }
    }
}
