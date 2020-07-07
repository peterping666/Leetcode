import java.util.PriorityQueue;

public class _407_TrappingRainWaterII {
    /**
     * Time O(m * n)
     * Space O(m * n)
     * @param heightMap
     * @return
     */
    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int i = 0; i < m; i++) {
            heap.offer(new int[]{i, 0, heightMap[i][0]});
            visited[i][0] = true;
            heap.offer(new int[]{i, n-1, heightMap[i][n-1]});
            visited[i][n-1] = true;
        }
        for(int j = 0; j < n; j++) {
            heap.offer(new int[]{0,j, heightMap[0][j]});
            heap.offer(new int[]{m-1,j, heightMap[m-1][j]});
            visited[0][j] = true;
            visited[m-1][j] = true;
        }
        int volume = 0;
        while(!heap.isEmpty()) {
            int[] cur = heap.poll();
            for(int[] dir : dirs) {
                int x = dir[0] + cur[0];
                int y = dir[1] + cur[1];
                if(x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) continue;
                volume += Math.max(0, cur[2] - heightMap[x][y]);
                visited[x][y] = true;
                heap.offer(new int[]{x, y, Math.max(cur[2], heightMap[x][y])});
            }
        }
        return volume;
    }
}
