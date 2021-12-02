public class _794_ValidTicTacToeState {
    class Solution {
        public boolean validTicTacToe(String[] board) {
            int count = 0; // # of X more than O
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    char c = board[i].charAt(j);
                    if(c == 'X') {
                        count++;
                    } else if(c == 'O') {
                        count--;
                    }
                }
            }
            if(count < 0 || count > 1) {
                return false;
            }
            if(count == 0 && win(board, 'X') || count == 1 && win(board, 'O')) {
                return false;
            }
            return true;
        }

        private boolean win(String[] board, char c) {
            for(int i = 0; i < 3; i++) {
                if (board[i].charAt(0) == c &&
                        board[i].charAt(1)  == c &&
                        board[i].charAt(2) == c) {
                    return true;
                }
                if (board[0].charAt(i) == c &&
                        board[1].charAt(i)  == c &&
                        board[2].charAt(i) == c) {
                    return true;
                }
            }
            if (board[1].charAt(1) == c &&
                    (board[0].charAt(0) == c &&
                            board[2].charAt(2) == c
                            || board[0].charAt(2) == c &&
                            board[2].charAt(0) == c)) {
                return true;
            }
            return false;
        }
    }
}
