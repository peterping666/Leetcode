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
            boolean[][] seen = new boolean[m][n];
            Queue<int[]> queue = new ArrayDeque<>();
            int counter = 0;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] == 1) {
                        counter++;
                    } else if(grid[i][j] == 2) {
                        queue.offer(new int[]{i, j});
                        seen[i][j] = true;
                    }
                }
            }
            if(counter == 0) {
                return 0;
            }
            int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
            int res = 0;
            while(!queue.isEmpty()) {
                int size = queue.size();
                while(size-- > 0) {
                    int[] cur = queue.poll();
                    for(int[] dir : dirs) {
                        int x = dir[0] + cur[0];
                        int y = dir[1] + cur[1];
                        if(x >= 0 && x < m && y >= 0 && y < n && !seen[x][y] && grid[x][y] == 1) {
                            queue.offer(new int[]{x,y});
                            seen[x][y] = true;
                            counter--;
                        }
                    }
                }
                res++;
            }
            return counter == 0 ? res - 1 : -1;
        }
    }
}
