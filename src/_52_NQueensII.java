public class _52_NQueensII {
    /**
     * Time O(n!)
     * Space O(n)
     * @param n
     * @return
     */
    public int totalNQueens1(int n) {
        return helper(n, 0, new int[n]);
    }

    private int helper(int n, int row, int[] queens) {
        if(row == n) {
            return 1;
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
            queens[row] = i;
            if(isValid(row, queens)) {
                count += helper(n, row + 1, queens);
            }
        }
        return count;
    }

    private boolean isValid(int row, int[] queens) {
        for(int i = 0; i < row; i++) {
            if(queens[row] == queens[i]) return false;
            if(Math.abs(queens[row] - queens[i]) == Math.abs(i - row)) return false;
        }
        return true;
    }


    /**
     * Time O(n!)
     * Space O(n)
     * @param n
     * @return
     */
    public int totalNQueens2(int n) {
        return helper(n, 0, new boolean[n], new boolean[2*n], new boolean[2*n]);
    }

    private int helper(int n, int row, boolean[] cols, boolean[] dales, boolean[] hills) {
        if(row == n) {
            return 1;
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
            int dale = i - row + n;
            int hill = i + row;
            if(cols[i] || dales[dale] || hills[hill]) continue;
            cols[i] = true; dales[dale] = true; hills[hill] = true;
            count += helper(n, row + 1, cols, dales, hills);
            cols[i] = false; dales[dale] = false; hills[hill] = false;
        }
        return count;
    }
}
