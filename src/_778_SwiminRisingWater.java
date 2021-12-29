import java.util.PriorityQueue;
import java.util.Queue;

public class _778_SwiminRisingWater {
    class Solution {
        public int swimInWater(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            Queue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
            heap.offer(new int[]{grid[0][0], 0, 0});
            int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
            boolean[][] seen = new boolean[m][n];
            seen[0][0] = true;
            int res = grid[0][0];
            while(!heap.isEmpty()) {
                int[] cur = heap.poll();
                res = Math.max(res, cur[0]);
                if(cur[1] == m-1 && cur[2] == n-1) {
                    break;
                }
                for(int[] dir : dirs) {
                    int x = cur[1] + dir[0];
                    int y = cur[2] + dir[1];
                    if(x < 0 || x >= m || y < 0 || y >= n || seen[x][y]) {
                        continue;
                    }
                    heap.offer(new int[]{grid[x][y], x, y});
                    seen[x][y] = true;
                }
            }
            return res;
        }
    }
}
