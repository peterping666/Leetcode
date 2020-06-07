import java.util.LinkedList;
import java.util.Queue;

public class _130_SurroundedRegions {
    /**
     * Time O(n)
     * Space O(n)
     * @param board
     */
    public void solve1(char[][] board) {
        if(board == null || board.length == 0) return;
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i < n; i++) {
            if(board[i][0] == 'O') {
                dfs(board, i, 0, n, m);
            }
            if(board[i][m-1] == 'O') {
                dfs(board, i, m-1, n, m);
            }
        }

        for(int j = 0; j < m ; j++) {
            if(board[0][j] == 'O') {
                dfs(board, 0, j, n, m);
            }
            if(board[n-1][j] == 'O') {
                dfs(board, n - 1, j, n, m);
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 'Y') {
                    board[i][j] = 'O';
                } else if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void dfs(char[][] board, int i, int j, int n, int m) {
        if(i < 0 || i >= n || j < 0 || j >= m || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'Y';
        dfs(board, i, j + 1, n, m);
        dfs(board, i, j - 1, n, m);
        dfs(board, i + 1, j, n, m);
        dfs(board, i - 1, j, n, m);
    }

    /**
     * Time O(n)
     * Space O(n)
     * @param grid
     */
    public int numIslands2(char[][] grid) {
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
                bfs(grid, i, j, n, m, visited);
                count++;
            }
        }
        return count;
    }

    private void bfs(char[][] board, int i, int j, int n, int m, boolean[][] visited) {
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        while(!queue.isEmpty()) {
            int[] coordinates = queue.poll();
            for(int[] dir : dirs) {
                int x = coordinates[0] + dir[0];
                int y = coordinates[1] + dir[1];
                if(x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || board[x][y] != '1') continue;
                queue.offer(new int[]{x, y});
                visited[x][y] = true;
            }
        }
    }
}
