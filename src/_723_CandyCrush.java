public class _723_CandyCrush {
    class Solution {
        public int[][] candyCrush(int[][] board) {
            int n = board.length;
            int m = board[0].length;
            boolean found = true;
            while(found) {
                found = false;
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < m; j++) {
                        if(board[i][j] == 0) {
                            continue;
                        }
                        int val = Math.abs(board[i][j]);
                        // check right dir
                        if(j < m - 2 && val == Math.abs(board[i][j + 1]) && val == Math.abs(board[i][j + 2])) {
                            found = true;
                            for(int k = 0; k < 3; k++) {
                                board[i][j + k] = -val;
                            }
                        }
                        // check downside dir
                        if(i < n - 2 && val == Math.abs(board[i + 1][j]) && val == Math.abs(board[i + 2][j])) {
                            found = true;
                            for(int k = 0; k < 3; k++) {
                                board[i + k][j] = -val;
                            }
                        }
                    }
                }
                if(found) {
                    eliminate(board, n, m);
                }
            }
            return board;
        }

        private void eliminate(int[][] board, int n, int m) {
            for(int j = 0; j < m; j++) {
                int index = n - 1;
                for(int i = n - 1; i >= 0; i--) {
                    if(board[i][j] > 0) {
                        board[index--][j] = board[i][j];
                    }
                }
                while(index >= 0) {
                    board[index--][j] = 0;
                }
            }
        }
    }
}
