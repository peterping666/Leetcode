package Laicode;

public class _138_MaximumPathSumBinaryTreeI {
    public class Solution {
        public int maxPathSum(TreeNode root) {
            int[] maxSum = new int[1];
            maxSum[0] = Integer.MIN_VALUE;
            helper(root, maxSum);
            return maxSum[0];
        }
        private int helper(TreeNode root, int[] maxSum) {
            if(root == null) {
                return 0;
            }
            int left = helper(root.left, maxSum);
            int right = helper(root.right, maxSum);
            if(root.left != null && root.right != null) {
                maxSum[0] = Math.max(maxSum[0], root.key + left + right);
                return root.key + Math.max(left, right);
            }
            return root.key + (root.left != null ? left : right);
        }
    }
}
