import java.util.LinkedList;
import java.util.Queue;

public class _317_ShortestDistancefromAllBuildings {
    /**
     * Time O(m^2 * n^2)
     * Space O(m * n)
     * @param grid
     * @return
     */
    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        int n = grid.length;
        int m = grid[0].length;
        int[][] dist = new int[n][m];
        int[][] reach = new int[n][m];
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    bfs(grid, i, j, n, m, dist, reach);
                    count++;
                }

            }
        }
        int distance = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(reach[i][j] != count || dist[i][j] == 0) continue;
                distance = Math.min(distance, dist[i][j]);
            }
        }
        return distance == Integer.MAX_VALUE ? -1 : distance;
    }

    private void bfs(int[][] grid, int i, int j, int n, int m, int[][] dist, int[][] reach) {
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        visited[i][j] = true;
        queue.offer(new int[]{i, j});
        int distance = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for(int k = 0; k < size; k++) {
                int[] coordinates = queue.poll();
                for(int[] dir : dirs) {
                    int x = coordinates[0] + dir[0];
                    int y = coordinates[1] + dir[1];
                    if(x < 0 || x >= n || y < 0 || y >= m || grid[x][y] != 0 || visited[x][y]) continue;
                    dist[x][y] += distance;
                    queue.offer(new int[]{x, y});
                    visited[x][y] = true;
                    reach[x][y]++;
                }
            }
        }
    }
}
