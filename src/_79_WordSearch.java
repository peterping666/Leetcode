public class _79_WordSearch {
    /**
     * Time O(m * n * 4^L) L is the length of the word
     * Space O(L)
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) return false;
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(dfs(board, i, j, n, m, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int n, int m, String word, int index) {
        if(i < 0 || i >= n || j < 0 || j >= m || board[i][j] != word.charAt(index)) return false;
        if(index == word.length() - 1) return true;
        char c = board[i][j];
        board[i][j] = '$';
        boolean result =  dfs(board, i, j + 1, n, m, word, index + 1)
                || dfs(board, i, j - 1, n, m, word, index + 1)
                || dfs(board, i + 1, j, n, m, word, index + 1)
                || dfs(board, i - 1, j, n, m, word, index + 1);
        board[i][j] = c;
        return result;
    }
}
