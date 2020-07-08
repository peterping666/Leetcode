public class _529_Minesweeper {
    /**
     * Time O(m * n)
     * Space O(m * n)
     * @param board
     * @param click
     * @return
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if(board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        dfs(board, x, y);
        return board;
    }

    private void dfs(char[][] board, int x, int y) {
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 'E') return;
        int mines = findMinesNum(board, x, y);
        if(mines == 0) {
            board[x][y] = 'B';
            for(int i = -1; i <= 1; i++) {
                for(int j = -1; j <= 1; j++) {
                    dfs(board, x + i, y + j);
                }
            }
        } else {
            board[x][y] = (char)('0' + mines);
        }
    }

    private int findMinesNum(char[][] board, int x, int y) {
        int count = 0;
        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                int newX = x + i;
                int newY = y + j;
                if(newX < 0 || newY < 0 || newX >= board.length || newY >= board[0].length) continue;
                if(board[newX][newY] == 'M') {
                    count++;
                }
            }
        }
        return count;
    }
}
