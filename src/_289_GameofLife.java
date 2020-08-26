public class _289_GameofLife {
    /**
     * Time O(m * n)
     * Space O(1)
     */
    class Solution {
        public void gameOfLife(int[][] board) {
            int m = board.length;
            int n = board[0].length;
            int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    int neighbors = getNeighbors(board, i, j, dirs);
                    if(board[i][j] > 0) {
                        if(neighbors < 2 || neighbors > 3) {
                            board[i][j] = 2;
                        }
                    } else {
                        if(neighbors == 3) {
                            board[i][j] = -1;
                        }
                    }
                }
            }
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(board[i][j] == 2) {
                        board[i][j] = 0;
                    } else if(board[i][j] == -1) {
                        board[i][j] = 1;
                    }
                }
            }
        }

        private int getNeighbors(int[][] board, int i, int j, int[][] dirs) {
            int count = 0;
            for(int[] dir : dirs) {
                int x = dir[0] + i;
                int y = dir[1] + j;
                if(x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] > 0) {
                    count++;
                }
            }
            return count;
        }
    }

    /**
     *
     * @param board
     */
    public void gameOfLife2(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int neighbors = getNeightbors(board, i, j, m, n);
                if((board[i][j] == 1 && neighbors == 2) || neighbors == 3) {
                    board[i][j] += 2;
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }
    private int getNeightbors(int[][] board, int i, int j, int m, int n) {
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
        int count = 0;
        for(int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if(x >= 0 && x < m && y >= 0 && y < n && (board[x][y] & 1) == 1) {
                count++;
            }
        }
        return count;
    }
}
