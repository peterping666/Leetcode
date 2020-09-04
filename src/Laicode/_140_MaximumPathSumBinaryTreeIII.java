package Laicode;

public class _140_MaximumPathSumBinaryTreeIII {
    public class Solution {
        public int maxPathSum(TreeNode root) {
            int[] maxSum = new int[]{Integer.MIN_VALUE};
            helper(root, 0, maxSum);
            return maxSum[0];
        }
        private void helper(TreeNode root, int sum, int[] maxSum) {
            if(root == null) {
                return;
            }
            sum = Math.max(root.key, root.key + sum);
            maxSum[0] = Math.max(maxSum[0], sum);
            helper(root.left, sum, maxSum);
            helper(root.right, sum, maxSum);
        }
    }

}
