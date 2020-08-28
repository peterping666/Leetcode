import java.util.ArrayDeque;
import java.util.Queue;

public class _695_MaxAreaofIsland {
    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution1 {
        public int maxAreaOfIsland(int[][] grid) {
            int maxArea = 0;
            int m = grid.length;
            int n = grid[0].length;
            int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
            boolean[][] visited = new boolean[m][n];

            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] == 1 && !visited[i][j]) {
                        maxArea = Math.max(maxArea, getArea(grid, i, j, m, n, dirs, visited));
                    }
                }
            }
            return maxArea;
        }

        private int getArea(int[][] grid, int i, int j, int m, int n, int[][] dirs, boolean[][] visited) {
            if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || visited[i][j]) {
                return 0;
            }
            int area = 1;
            visited[i][j] = true;
            for(int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                area += getArea(grid, x, y, m, n, dirs, visited);
            }
            return area;
        }
    }

    /**
     * Time O(n)
     * Space O(m + n)
     */
    class Solution2 {
        public int maxAreaOfIsland(int[][] grid) {
            int maxArea = 0;
            int m = grid.length;
            int n = grid[0].length;
            int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
            boolean[][] visited = new boolean[m][n];

            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] == 1 && !visited[i][j]) {
                        maxArea = Math.max(maxArea, getArea(grid, i, j, m, n, dirs, visited));
                    }
                }
            }
            return maxArea;
        }

        private int getArea(int[][] grid, int i, int j, int m, int n, int[][] dirs, boolean[][] visited) {
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(i * n + j);
            visited[i][j] = true;
            int area = 0;

            while(!queue.isEmpty()) {
                int curIndex = queue.poll();
                area++;
                for(int[] dir : dirs) {
                    int x = dir[0] + curIndex / n;
                    int y = dir[1] + curIndex % n;
                    if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1 && !visited[x][y]) {
                        queue.offer(x * n + y);
                        visited[x][y] = true;
                    }
                }
            }
            return area;
        }
    }
}
