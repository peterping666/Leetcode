package Laicode;

public class _139_MaximumPathSumBinaryTreeII {
    public class Solution {
        public int maxPathSum(TreeNode root) {
            int[] maxSum = new int[1];
            maxSum[0] = root.key;
            helper(root, maxSum);
            return maxSum[0];
        }

        private int helper(TreeNode root, int[] maxSum) {
            if(root == null) {
                return 0;
            }
            int left = Math.max(0, helper(root.left, maxSum));
            int right = Math.max(0, helper(root.right, maxSum));
            maxSum[0] = Math.max(maxSum[0], root.key + left + right);
            return root.key + Math.max(left, right);
        }
    }
}
