package Laicode;

public class _638_LargestSquareOfMatches {
    public class Solution {
        public int largestSquareOfMatches(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int res = 0;
            int[][] right = new int[m + 1][n + 1];
            int[][] down = new int[m + 1][n + 1];
            for(int i = m - 1; i >= 0; i--) {
                for(int j = n - 1; j >= 0; j--) {
                    if(hasRight(matrix[i][j])) {
                        right[i][j] = right[i][j + 1] + 1;
                    }
                    if(hasDown(matrix[i][j])) {
                        down[i][j] = down[i + 1][j] + 1;
                    }
                    if(hasBoth(matrix[i][j])) {
                        for(int maxLen = Math.min(right[i][j], down[i][j]); maxLen >= 1; maxLen--) {
                            if(right[i + maxLen][j] >= maxLen && down[i][j + maxLen] >= maxLen) {
                                res = Math.max(res, maxLen);
                                break;
                            }
                        }
                    }
                }
            }
            return res;
        }

        private boolean hasRight(int value) {
            return (value & 0b1) != 0;
        }

        private boolean hasDown(int value) {
            return (value & 0b10) != 0;
        }

        private boolean hasBoth(int value) {
            return value == 0b11;
        }
    }

}
