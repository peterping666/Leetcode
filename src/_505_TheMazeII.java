import java.util.Arrays;
import java.util.HashMap;
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
    public int shortestDistance1(int[][] maze, int[] start, int[] destination) {
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

    /**
     *
     * @param maze
     * @param start
     * @param destination
     * @return
     */
    public int shortestDistance2(int[][] maze, int[] start, int[] destination) {
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> distance = new HashMap<>();
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int m = maze.length;
        int n = maze[0].length;
        queue.offer(start[0] * n + start[1]);
        distance.put(start[0] * n + start[1], 0);
        int res = m * n;
        while(!queue.isEmpty()) {
            int idx = queue.poll();
            for(int i = 0; i < dirs.length; i++) {
                int dist = distance.get(idx);
                int x = idx / n;
                int y = idx % n;
                if(i > 1) {
                    while(x + dirs[i][0] >= 0 && x + dirs[i][0] < m && maze[x + dirs[i][0]][y] == 0) {
                        x += dirs[i][0];
                        dist++;
                    }
                } else {
                    while(y + dirs[i][1] >= 0 && y + dirs[i][1] < n && maze[x][y + dirs[i][1]] == 0) {
                        y += dirs[i][1];
                        dist++;
                    }
                }
                int index = x * n + y;
                if(!distance.containsKey(index) || distance.get(index) > dist) {
                    distance.put(index, dist);
                    queue.offer(index);
                }
                if(x == destination[0] && y == destination[1]) {
                    res = Math.min(res, distance.get(index));
                }
            }
        }
        return res == m * n ? -1 : res;
    }
}
