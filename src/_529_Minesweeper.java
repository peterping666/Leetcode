public class _529_Minesweeper {
    /**
     * Time O(m * n)
     * Space O(1)
     */
    class Solution {
        public char[][] updateBoard(char[][] board, int[] click) {
            int i = click[0], j = click[1];
            if(board[i][j] == 'M') {
                board[i][j] = 'X';
                return board;
            }
            int m = board.length, n = board[0].length;
            helper(board, i, j, m, n);
            return board;
        }

        private void helper(char[][] board, int i, int j, int m, int n) {
            int count = 0;
            int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
            for(int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                if(x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'M') {
                    count++;
                }
            }
            if(count > 0) {
                board[i][j] = (char)(count + '0');
            } else {
                board[i][j] = 'B';
                for(int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if(x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'E') {
                        helper(board, x, y, m, n);
                    }
                }
            }
        }
    }
}
