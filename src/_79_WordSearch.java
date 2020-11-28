public class _79_WordSearch {
    /**
     * Time O(m * n * 3^L) L is the length of the word
     * Space O(L)
     */
    class Solution {
        public boolean exist(char[][] board, String word) {
            int n = board.length;
            int m = board[0].length;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(dfs(board, i, j, word, 0, n, m)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, int i, int j, String word, int index, int n, int m) {
            if(index == word.length()) {
                return true;
            }
            if(i < 0 || i >= n || j < 0 || j >= m || board[i][j] == '#' || board[i][j] != word.charAt(index)) {
                return false;
            }
            char c = board[i][j];
            board[i][j] = '#';
            if(dfs(board, i + 1, j, word, index + 1, n, m) ||
                    dfs(board, i - 1, j, word, index + 1, n, m) ||
                    dfs(board, i, j + 1, word, index + 1, n, m) ||
                    dfs(board, i, j - 1, word, index + 1, n, m)) {
                return true;
            }
            board[i][j] = c;
            return false;
        }
    }
}
