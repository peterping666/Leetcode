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
     * Time O(n * m)
     * Space O(max(n,m))
     * @param grid
     * @return
     */
    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    grid[r][c] = '0'; // mark as visited
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            neighbors.add((row-1) * nc + col);
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row+1][col] == '1') {
                            neighbors.add((row+1) * nc + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            neighbors.add(row * nc + col-1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col+1] == '1') {
                            neighbors.add(row * nc + col+1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }
        return num_islands;
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
