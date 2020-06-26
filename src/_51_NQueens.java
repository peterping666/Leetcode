import java.util.ArrayList;
import java.util.List;

public class _51_NQueens {
    /**
     * Time O(n^n)
     * Space O(n)
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> lists = new ArrayList<>();
        helper(lists, 0, new int[n]);
        return lists;
    }

    private void helper(List<List<String>> lists, int row, int[] queens) {
        if(row == queens.length) {
            addSolution(queens, lists);
            return;
        }
        for(int i = 0; i < queens.length; i++) {
            queens[row] = i;
            if(isValid(queens, row)) {
                helper(lists, row + 1, queens);
            }
        }
    }

    private boolean isValid(int[] queens, int row) {
        for(int i = 0; i < row; i++) {
            if(queens[i] == queens[row]) return false;
            if(Math.abs(queens[i] - queens[row]) == Math.abs(i - row)) return false;
        }
        return true;
    }

    private void addSolution(int[] queens, List<List<String>> lists) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < queens.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < queens.length; j++) {
                if(j != queens[i]) {
                    sb.append(".");
                } else {
                    sb.append("Q");
                }
            }
            list.add(sb.toString());
        }
        lists.add(list);
    }
}
