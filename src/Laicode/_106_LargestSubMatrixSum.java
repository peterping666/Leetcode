package Laicode;

public class _106_LargestSubMatrixSum {
    /**
     * Time O(n^3)
     * Space O(n^2)
     */
    public class Solution {
        public int largest(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] prefixColSum = new int[m][n];
            for(int j = 0; j < n; j++) {
                for(int i = 0; i < m; i++) {
                    if(i == 0) {
                        prefixColSum[i][j] = matrix[i][j];
                    } else {
                        prefixColSum[i][j] = prefixColSum[i - 1][j] + matrix[i][j];
                    }
                }
            }
            int maxSum = matrix[0][0];
            for(int i = 0; i < m; i++) {
                for(int j = i; j < m; j++) {
                    int[] nums = new int[n];
                    for(int k = 0; k < n; k++) {
                        nums[k] = prefixColSum[j][k] - prefixColSum[i][k] + matrix[i][k];
                    }
                    int cur = nums[0];
                    maxSum = Math.max(maxSum, nums[0]);
                    for(int k = 1; k < n; k++) {
                        cur = Math.max(nums[k], nums[k] + cur);
                        maxSum = Math.max(maxSum, cur);
                    }
                }
            }
            return maxSum;
        }
    }
}
