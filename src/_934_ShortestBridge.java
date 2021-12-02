import java.util.ArrayDeque;
import java.util.Queue;

public class _934_ShortestBridge {
    class Solution {
        public int shortestBridge(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            Queue<int[]> queue = new ArrayDeque<>();
            boolean[][] seen = new boolean[m][n];
            boolean found = false;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] == 1) {
                        dfs(grid, i, j, queue, seen);
                        found = true;
                        break;
                    }
                }
                if(found) {
                    break;
                }
            }
            return bfs(grid, queue, seen);
        }

        private void dfs(int[][] grid, int i, int j, Queue<int[]> queue, boolean[][] seen) {
            if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || seen[i][j] || grid[i][j] == 0) {
                return;
            }
            queue.offer(new int[]{i,j});
            seen[i][j] = true;
            dfs(grid, i+1, j, queue, seen);
            dfs(grid, i-1, j, queue, seen);
            dfs(grid, i, j+1, queue, seen);
            dfs(grid, i, j-1, queue, seen);
        }

        private int bfs(int[][] grid, Queue<int[]> queue, boolean[][] seen) {
            int res = 0;
            int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
            while(!queue.isEmpty()) {
                int size = queue.size();
                while(size-- > 0) {
                    int[] cur = queue.poll();
                    for(int[] dir : dirs) {
                        int x = cur[0] + dir[0];
                        int y = cur[1] + dir[1];
                        if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && !seen[x][y]){
                            if(grid[x][y] == 1) {
                                return res;
                            }
                            queue.offer(new int[]{x,y});
                            seen[x][y] = true;
                        }
                    }
                }
                res++;
            }
            return res;
        }
    }
}
