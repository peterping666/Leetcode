import java.util.ArrayDeque;
import java.util.Queue;

public class _994_RottingOranges {
    /**
     * Time O(m * n)
     * Space O(m * n)
     */
    class Solution {
        public int orangesRotting(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int count = 0;
            Queue<Integer> queue = new ArrayDeque<>();
            boolean[][] visited = new boolean[m][n];
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] == 1) {
                        count++;
                    } else if(grid[i][j] == 2) {
                        queue.offer(i * n + j);
                        visited[i][j] = true;
                    }
                }
            }
            if(count == 0) {
                return 0;
            }
            int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
            int time = 0;
            while(!queue.isEmpty()) {
                int size = queue.size();
                time++;
                for(int i = 0; i < size; i++) {
                    int cur = queue.poll();
                    for(int[] dir : dirs) {
                        int x = dir[0] + cur / n;
                        int y = dir[1] + cur % n;
                        if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1 && !visited[x][y]) {
                            queue.offer(x * n + y);
                            visited[x][y] = true;
                            count--;
                        }
                    }
                }
            }
            return count == 0? time - 1 : -1;
        }
    }
}
