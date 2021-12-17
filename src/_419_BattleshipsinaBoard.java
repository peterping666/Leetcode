public class _419_BattleshipsinaBoard {
    /**
     * Time O(n * m)
     * Space O(1)
     */
    class Solution {
        public int countBattleships(char[][] board) {
            int res = 0, m = board.length, n = board[0].length;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(board[i][j] == 'X') {
                        if(i > 0 && board[i-1][j] == 'X') {
                            continue;
                        }
                        res++;
                        while(j < n && board[i][j] == 'X') {
                            j++;
                        }
                    }
                }
            }
            return res;
        }
    }
}
