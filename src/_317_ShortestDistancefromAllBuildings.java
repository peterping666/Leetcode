import java.util.ArrayDeque;
import java.util.Queue;

public class _317_ShortestDistancefromAllBuildings {
    /**
     * Time O(mn * b) // b = # of 0
     * Space O(mn)
     */
    class Solution {
        public int shortestDistance(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[][] travel = new int[m][n];
            int[][] reach = new int[m][n];
            int count = 0;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] == 1) {
                        bfs(grid, travel, reach, m, n, i, j);
                        count++;
                    }
                }
            }

            int res = Integer.MAX_VALUE;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(travel[i][j] != 0 && reach[i][j] == count) {
                        res = Math.min(res, travel[i][j]);
                    }
                }
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }

        private void bfs(int[][] grid, int[][] travel, int[][] reach, int m, int n, int i, int j) {
            Queue<int[]> queue = new ArrayDeque<>();
            boolean[][] seen = new boolean[m][n];
            queue.offer(new int[]{i, j});
            seen[i][j] = true;
            reach[i][j]++;
            int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
            int dist = 0;
            while(!queue.isEmpty()) {
                int size = queue.size();
                dist++;
                while(size-- > 0) {
                    int[] cur = queue.poll();
                    for(int[] dir : dirs) {
                        int x = cur[0] + dir[0];
                        int y = cur[1] + dir[1];
                        if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 2 || seen[x][y] ||
                                grid[x][y] == 1) {
                            continue;
                        }
                        travel[x][y] += dist;
                        queue.offer(new int[]{x, y});
                        seen[x][y] = true;
                        reach[x][y]++;
                    }
                }
            }
        }
    }
}
