public class _723_CandyCrush {
    class Solution {
        public int[][] candyCrush(int[][] board) {
            int m = board.length;
            int n = board[0].length;
            boolean end = false;
            while (!end) {
                end = true;
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        int val = Math.abs(board[i][j]);
                        if (val == 0) continue; //因为填充是用0填充的，如果没这句那就死循环，对填充的0死缠烂打
                        if (j < n - 2 && Math.abs(board[i][j + 1]) == val && Math.abs(board[i][j + 2]) == val) {
                            end = false;
                            for(int k=j; k<=j+2; k++)board[i][k]=-val;       //优化1
                        }
                        if (i < m - 2 && Math.abs(board[i + 1][j]) == val && Math.abs(board[i + 2][j]) == val) {
                            end = false;
                            for(int k=i; k<=i+2; k++)board[k][j]=-val;      //优化1
                        }
                    }
                }
                if (!end) {
                    for (int j = 0; j < n; j++) {
                        int temp = m - 1;   //用于记录填充的位置
                        for (int i = m - 1; i >= 0; i--) { //对于同一列，从下往上，找到没删除的candy填充到temp处
                            if (board[i][j] > 0) {
                                board[temp--][j] = board[i][j];
                            }
                        }
                        for (int i = temp; i >= 0; i--) board[i][j] = 0;
                    }
                }
            }
            return board;
        }
    }
}
