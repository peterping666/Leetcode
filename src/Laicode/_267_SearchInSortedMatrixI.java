package Laicode;

public class _267_SearchInSortedMatrixI {
    public class Solution {
        public int[] search(int[][] matrix, int target) {
            // Write your solution here
            if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
                return new int[]{-1, -1};
            }
            int m = matrix.length;
            int n = matrix[0].length;
            int row = findRow(matrix, target);
            if(row == -1) {
                return new int[]{-1, -1};
            }
            int col = findCol(matrix[row], target);
            return col == -1 ? new int[]{-1, -1} : new int[]{row, col};
        }

        private int findRow(int[][] matrix, int target) {
            int up = 0;
            int bottom = matrix.length - 1;
            while(up <= bottom) {
                int mid = up + (bottom - up) / 2;
                if(matrix[mid][0] > target) {
                    bottom = mid - 1;
                } else {
                    up = mid + 1;
                }
            }
            return bottom;
        }
        private int findCol(int[] array, int target) {
            int left = 0;
            int right = array.length - 1;
            while(left <= right) {
                int mid = left + (right - left) / 2;
                if(array[mid] == target) {
                    return mid;
                } else if(array[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }

}
