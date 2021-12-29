import java.util.PriorityQueue;
import java.util.Queue;

public class _407_TrappingRainWaterII {
    /**
     * Time O(m * n)
     * Space O(m * n)
     */
    class Solution {
        public int trapRainWater(int[][] heightMap) {
            int m = heightMap.length, n = heightMap[0].length;
            boolean[][] seen = new boolean[m][n];
            Queue<Cell> heap = new PriorityQueue<>((a, b) -> Integer.compare(a.height, b.height));
            for(int i = 0; i < m; i++) {
                seen[i][0] = true;
                heap.offer(new Cell(i, 0, heightMap[i][0]));
                seen[i][n-1] = true;
                heap.offer(new Cell(i, n-1, heightMap[i][n-1]));
            }

            for(int i = 0; i < n; i++) {
                seen[0][i] = true;
                heap.offer(new Cell(0, i, heightMap[0][i]));
                seen[m-1][i] = true;
                heap.offer(new Cell(m-1, i, heightMap[m-1][i]));
            }

            int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
            int res = 0;
            while(!heap.isEmpty()) {
                Cell cur = heap.poll();
                for(int[] dir : dirs) {
                    int x = dir[0] + cur.row;
                    int y = dir[1] + cur.col;
                    if(x < 0 || x >= m || y < 0 || y >= n || seen[x][y]) {
                        continue;
                    }
                    int next = heightMap[x][y];
                    res += Math.max(0, cur.height - next);
                    heap.offer(new Cell(x, y, Math.max(cur.height, next)));
                    seen[x][y] = true;
                }
            }
            return res;
        }

        class Cell {
            int row;
            int col;
            int height;

            Cell (int r, int c, int h) {
                row = r;
                col = c;
                height = h;
            }
        }
    }
}
