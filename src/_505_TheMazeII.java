import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _505_TheMazeII {
    /**
     * Time O(m * n)
     * Space O(m * n)
     * @param maze
     * @param start
     * @param destination
     * @return
     */
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] dirs = {{0,1},{0,-1}, {1,0}, {-1,0}};
        int n = maze.length;
        int m = maze[0].length;
        int[][] dists = new int[n][m];
        for(int[] dist : dists) {
            Arrays.fill(dist, -1);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1]});
        dists[start[0]][start[1]] = 0;
        while(!queue.isEmpty()) {
            int[] coordinates = queue.poll();
            for(int[] dir : dirs) {
                int x = coordinates[0];
                int y = coordinates[1];
                int dist = dists[x][y];
                while(isValid(maze, x + dir[0], y + dir[1], n, m)) {
                    x += dir[0];
                    y += dir[1];
                    dist++;
                }
                if(dists[x][y] == -1 || dist < dists[x][y]) {
                    queue.offer(new int[]{x, y});
                    dists[x][y] = dist;
                }
            }
        }
        return dists[destination[0]][destination[1]];
    }

    private boolean isValid(int[][] maze, int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m && maze[x][y] == 0;
    }
}
