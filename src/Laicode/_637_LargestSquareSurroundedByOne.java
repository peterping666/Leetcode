package Laicode;

public class _637_LargestSquareSurroundedByOne {
    /**
     * Time O(n^3)
     * Space O(n^2)
     */
    public class Solution {
        public int largestSquareSurroundedByOne(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int res = 0;
            int[][] left = new int[m + 1][n + 1];
            int[][] up = new int[m + 1][n + 1];
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(matrix[i][j] == 1) {
                        left[i + 1][j + 1] = left[i + 1][j] + 1;
                        up[i + 1][j + 1] = up[i][j + 1] + 1;
                    }
                    for(int maxLen = Math.min(left[i + 1][j + 1], up[i + 1][j + 1]); maxLen >= 1; maxLen--) {
                        if(left[i + 2 - maxLen][j + 1] >= maxLen && up[i + 1][j + 2 - maxLen] >= maxLen) {
                            res = Math.max(res, maxLen);
                            break;
                        }
                    }
                }
            }
            return res;
        }
    }

}
