import java.util.LinkedList;
import java.util.Queue;

public class _200_NumberofIslands {
    /**
     * Time O(n * m)
     * Space O(n * m)
     * @param grid
     * @return
     */
    public int numIslands1(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(visited[i][j] || grid[i][j] == '0') continue;
                dfs(visited, grid, i, j, n, m);
                count++;
            }
        }
        return count;
    }

    private void dfs(boolean[][] visited, char[][] grid, int i, int j, int n, int m) {
        if(i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || grid[i][j] == '0') {
            return;
        }
        visited[i][j] = true;
        dfs(visited, grid, i, j + 1, n, m);
        dfs(visited, grid, i, j - 1, n, m);
        dfs(visited, grid, i + 1, j, n, m);
        dfs(visited, grid, i - 1, j, n, m);
    }

    /**
     *
     * @param grid
     * @return
     */
    public int numIslands3(char[][] grid) {
        if(grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if(i - 1 >= 0 && grid[i-1][j] == '1') {
                        uf.union(i * n + j, (i-1) * n + j);
                    }
                    if(i + 1 < m && grid[i+1][j] == '1') {
                        uf.union(i * n + j, (i+1) * n + j);
                    }
                    if(j - 1 >= 0 && grid[i][j-1] == '1') {
                        uf.union(i * n + j, i * n + j-1);
                    }
                    if(j + 1 < n && grid[i][j+1] == '1') {
                        uf.union(i * n + j, i * n + j+1);
                    }
                }
            }
        }
        return uf.getCount();
    }

    class UnionFind {
        private int[] parent;
        private int count;

        public UnionFind(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            count = 0;
            parent = new int[m * n];
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] == '1') {
                        int idx = i * n + j;
                        parent[idx] = idx;
                        count++;
                    }
                }
            }
        }
        public int find(int num) {
            if(parent[num] != num) {
                parent[num] = find(parent[num]);
            }
            return parent[num];
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if(rootA == rootB) return;
            parent[rootA] = rootB;
            count--;
        }

        public int getCount() {
            return count;
        }
    }
}


class Solution2 {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        boolean[][] seen = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!seen[i][j] && grid[i][j] == '1') {

                    bfs(grid, seen, i, j, m, n);
                    res++;
                }
            }
        }
        return res;
    }

    private void bfs(char[][] grid, boolean[][] seen, int i, int j, int m, int n) {
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        seen[i][j] = true;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for(int[] dir : dirs) {
                int nx = dir[0] + x;
                int ny = dir[1] + y;
                if(valid(nx, ny, m, n, grid, seen)) {
                    queue.offer(new int[]{nx, ny});
                    seen[nx][ny] = true;
                }
            }
        }
    }

    private boolean valid(int i, int j, int m, int n, char[][] grid, boolean[][] seen) {
        return i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == '1' && !seen[i][j];
    }
}
