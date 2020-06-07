import java.util.LinkedList;
import java.util.Queue;

public class _286_WallsandGates {
    /**
     * Time O(m * n * k)
     * Space O(m * n)
     * @param rooms
     */
    public void wallsAndGates1(int[][] rooms) {
        if(rooms == null || rooms.length == 0) return;
        int n = rooms.length;
        int m = rooms[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(rooms[i][j] == 0) {
                    bfs(rooms, i, j, n, m);
                }
            }
        }
    }

    private void bfs(int[][] rooms, int i, int j, int n, int m) {
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        Queue<int[]> queue = new LinkedList<>();
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
                    if(x < 0 || x >= n || y < 0 || y >= m || distance >= rooms[x][y]) continue;
                    rooms[x][y] = distance;
                    queue.offer(new int[]{x, y});
                }
            }
        }
    }

    /**
     * Time O(m * n)
     * Space O(m * n)
     * @param rooms
     */
    public void wallsAndGates2(int[][] rooms) {
        if(rooms == null || rooms.length == 0) return;
        int n = rooms.length;
        int m = rooms[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(rooms[i][j] == 0) {
                    dfs(rooms, i, j, n, m, 0);
                }
            }
        }
    }

    private void dfs(int[][] rooms, int i, int j, int n, int m, int distance) {
        if(i < 0 || i >= n || j < 0 || j >= m || distance > rooms[i][j]) return;
        rooms[i][j] = distance;
        dfs(rooms, i, j + 1, n, m, distance + 1);
        dfs(rooms, i, j - 1, n, m, distance + 1);
        dfs(rooms, i + 1, j, n, m, distance + 1);
        dfs(rooms, i - 1, j, n, m, distance + 1);
    }
}
