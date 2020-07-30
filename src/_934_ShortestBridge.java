import java.util.ArrayDeque;
import java.util.Queue;

public class _934_ShortestBridge {
    class Solution {
        public int shortestBridge(int[][] A) {
            int m = A.length;
            int n = A[0].length;
            int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
            Queue<int[]> q = new ArrayDeque<>();
            boolean[][] visited = new boolean[m][n];
            boolean found = false;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(A[i][j] == 1) {
                        dfs(A, q, visited, i, j, dirs);
                        found = true;
                        break;
                    }
                }
                if(found) {
                    break;
                }
            }
            int dist = 0;
            while(!q.isEmpty()) {
                int size = q.size();
                for(int i = 0; i < size; i++) {
                    int[] cur = q.poll();
                    for(int[] dir : dirs) {
                        int x = cur[0] + dir[0];
                        int y = cur[1] + dir[1];
                        if(x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) {
                            continue;
                        }
                        if(A[x][y] == 1) {
                            return dist;
                        }
                        q.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
                dist++;
            }
            return -1;
        }

        private void dfs(int[][] A, Queue<int[]> q, boolean[][] visited, int i, int j, int[][] dirs) {
            int m = A.length;
            int n = A[0].length;
            if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || A[i][j] != 1) {
                return;
            }
            q.offer(new int[]{i, j});
            visited[i][j] = true;
            for(int[] dir : dirs) {
                dfs(A, q, visited, i + dir[0], j + dir[1], dirs);
            }
        }
    }
}
