public class _79_WordSearch {
    /**
     * Time O(m * n * 4^L) L is the length of the word
     * Space O(L)
     * @return
     */
    class Solution {
        public boolean exist(char[][] board, String word) {
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    if(helper(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean helper(char[][] board, String word, int i, int j, int index) {
            if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
                return false;
            }
            if(index == word.length() - 1) {
                return true;
            }
            char ch = board[i][j];
            board[i][j] = '#';

            boolean foundWord =  helper(board, word, i, j + 1, index + 1)
                    || helper(board, word, i, j - 1, index + 1)
                    || helper(board, word, i + 1, j, index + 1)
                    || helper(board, word, i - 1, j, index + 1);

            board[i][j] = ch;
            return foundWord;
        }
    }
}
