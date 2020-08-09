package Laicode;

import java.util.ArrayList;
import java.util.List;

public class _233_NQueens {
    /**
     * O(n) to check validation
     */
    public class Solution1 {
        public List<List<Integer>> nqueens(int n) {
            List<List<Integer>> res = new ArrayList<>();
            helper(res, n, new ArrayList<>());
            return res;
        }

        private void helper(List<List<Integer>> res, int n, List<Integer> columns) {
            if(columns.size() == n) {
                res.add(new ArrayList<>(columns));
                return;
            }
            for(int i = 0; i < n; i++) {
                if(valid(columns, i)) {
                    columns.add(i);
                    helper(res, n, columns);
                    columns.remove(columns.size() - 1);
                }
            }
        }

        private boolean valid(List<Integer> columns, int column) {
            int row = columns.size();
            for(int i = 0; i < row; i++) {
                if(columns.get(i) == column || Math.abs(columns.get(i) - column) == row - i) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * O(1) to check validation
     */
    public class Solution2 {
        public List<List<Integer>> nqueens(int n) {
            List<List<Integer>> res = new ArrayList<>();
            int[] queens = new int[n];
            boolean[] usedColumns = new boolean[n];
            boolean[] usedDiagonals = new boolean[2 * n - 1];
            boolean[] usedRevDiagonals = new boolean[2 * n - 1];
            helper(res, 0, queens, n, usedColumns, usedDiagonals, usedRevDiagonals);
            return res;
        }

        private void helper(List<List<Integer>> res, int row, int[] queens, int n, boolean[] usedColumns,
                            boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
            if(row == n) {
                res.add(toList(queens));
                return;
            }
            for(int i = 0; i < n; i++) {
                if(valid(n, row, i, usedColumns, usedDiagonals, usedRevDiagonals)) {
                    mark(n, row, i, usedColumns, usedDiagonals, usedRevDiagonals);
                    queens[row] = i;
                    helper(res, row + 1, queens, n, usedColumns, usedDiagonals, usedRevDiagonals);
                    unmark(n, row, i, usedColumns, usedDiagonals, usedRevDiagonals);
                }
            }
        }

        private boolean valid(int n, int row, int column, boolean[] usedColumns,
                              boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
            return !usedColumns[column] && !usedDiagonals[column + row] &&
                    !usedRevDiagonals[column - row + n - 1];
        }

        private void mark(int n, int row, int column, boolean[] usedColumns,
                          boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
            usedColumns[column] = true;
            usedDiagonals[column + row] = true;
            usedRevDiagonals[column - row + n - 1] = true;
        }

        private void unmark(int n, int row, int column, boolean[] usedColumns,
                            boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
            usedColumns[column] = false;
            usedDiagonals[column + row] = false;
            usedRevDiagonals[column - row + n - 1] = false;
        }

        private List<Integer> toList(int[] array) {
            List<Integer> list = new ArrayList<>();
            for(int num : array) {
                list.add(num);
            }
            return list;
        }
    }

}
