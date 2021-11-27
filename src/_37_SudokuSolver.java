public class _37_SudokuSolver {
    /**
     * Time O(m * n * (m + n))
     * Space O(1)
     */
    class Solution {
        public void solveSudoku(char[][] board) {
            solve(board,  0, 0);
        }

        private boolean solve(char[][] board, int row, int col) {
            for(int i = row; i < 9; i++, col = 0) {
                for(int j = col; j < 9; j++) {
                    if(board[i][j] != '.') {
                        continue;
                    }
                    for(char c = '1'; c <= '9'; c++) {
                        if(isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if(solve(board, i, j+1)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
            return true;
        }

        private boolean isValid(char[][] board, int row, int col, char c) {
            for(int i = 0; i < 9; i++) {
                int blockRow = 3 * (row / 3);
                int blockCol = 3 * (col / 3);
                if(board[i][col] == c || board[row][i] == c || board[blockRow + i/3][blockCol + i%3] == c) {
                    return false;
                }
            }
            return true;
        }
    }
}
