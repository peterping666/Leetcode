import java.util.HashSet;

public class _36_ValidSudoku {
    class Solution1 {
        public boolean isValidSudoku(char[][] board) {
            HashSet<Character>[] rows = new HashSet[9];
            HashSet<Character>[] cols = new HashSet[9];
            HashSet<Character>[] boxes = new HashSet[9];
            for (int i = 0; i < 9; i++) {
                rows[i] = new HashSet<Character>();
                cols[i] = new HashSet<Character>();
                boxes[i] = new HashSet<Character>();
            }
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    char c = board[i][j];
                    if(c == '.') {
                        continue;
                    }
                    int idx = 3 * (i / 3) + j / 3;
                    if(!rows[i].add(c) || !cols[j].add(c) || !boxes[idx].add(c)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    class Solution2 {
        public boolean isValidSudoku(char[][] board) {
            for (int i = 0; i < board.length; i++) {
                HashSet<Character> rows = new HashSet<>();
                HashSet<Character> cols = new HashSet<>();
                HashSet<Character> boxes = new HashSet<>();
                for(int j = 0; j < board[0].length; j++) {
                    if(board[i][j] != '.' && !rows.add(board[i][j])) {
                        return false;
                    }
                    if(board[j][i] != '.' && !cols.add(board[j][i])) {
                        return false;
                    }
                    int rowIdx = 3 * (i / 3) + j / 3;
                    int colIdx = 3 * (i % 3) + j % 3;
                    if(board[rowIdx][colIdx] != '.' && !boxes.add(board[rowIdx][colIdx])) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
