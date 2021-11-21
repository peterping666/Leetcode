public class _240_Search2DMatrixII {
    /**
     * Time O(m + n)
     * Space O(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        int i = m - 1, j = 0;
        while(i >= 0 && j < n) {
            if(matrix[i][j] == target) return true;
            if(matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
}
