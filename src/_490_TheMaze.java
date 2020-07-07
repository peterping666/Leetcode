import java.util.LinkedList;
import java.util.Queue;

public class _490_TheMaze {
    /**
     * Time O(m * n)
     * Space O(m * n)
     * @param maze
     * @param start
     * @param destination
     * @return
     */
    public boolean hasPath1(int[][] maze, int[] start, int[] destination) {
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int n = maze.length;
        int m = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1]});
        boolean[][] visited = new boolean[n][m];
        visited[start[0]][start[1]] = true;
        while(!queue.isEmpty()) {
            int[] coordinates = queue.poll();
            for(int[] dir : dirs) {
                int x = coordinates[0];
                int y = coordinates[1];
                while(isValid(maze, x + dir[0], y + dir[1], n, m)) {
                    x += dir[0];
                    y += dir[1];
                }
                if(!visited[x][y]) {
                    if(x == destination[0] && y == destination[1]) {
                        return true;
                    } else {
                        queue.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
        }
        return false;
    }
    private boolean isValid(int[][] maze, int x, int y, int n, int m) {
        return !(x < 0 || x >= n || y < 0 || y >= m || maze[x][y] == 1);
    }

    /**
     *
     * @param maze
     * @param start
     * @param destination
     * @return
     */
    public boolean hasPath2(int[][] maze, int[] start, int[] destination) {
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        return dfs(start[0], start[1], destination, dirs, maze, new boolean[maze.length][maze[0].length]);
    }

    private boolean dfs(int i, int j, int[] dest, int[][] dirs, int[][] maze, boolean[][] seen) {
        if(seen[i][j]) {
            return false;
        }
        if(i == dest[0] && j == dest[1]) return true;
        seen[i][j] = true;
        for(int k = 0; k < dirs.length; k++) {
            int x = i;
            int y = j;
            if(k > 1) {
                while(x + dirs[k][0] >= 0 && x + dirs[k][0] < maze.length && maze[x+dirs[k][0]][y] == 0) {
                    x += dirs[k][0];
                }
            }
            if(k <= 1) {
                while(y + dirs[k][1] >= 0 && y + dirs[k][1] < maze[0].length && maze[x][y + dirs[k][1]] == 0) {
                    y += dirs[k][1];
                }
            }
            if(dfs(x, y, dest, dirs, maze, seen)) return true;
        }
        return false;
    }
}
