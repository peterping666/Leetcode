public class _124_BinaryTreeMaximumPathSum {
    /**
     * Time O(n)
     * Space O(h)
     */
    class Solution {
        public int maxPathSum(TreeNode root) {
            int[] maxSum = new int[1];
            maxSum[0] = root.val;
            helper(root, maxSum);
            return maxSum[0];
        }

        private int helper(TreeNode root, int[] maxSum) {
            if(root == null) {
                return 0;
            }
            int left = Math.max(0, helper(root.left, maxSum));
            int right = Math.max(0, helper(root.right, maxSum));
            int curSum = root.val + left + right;
            maxSum[0] = Math.max(maxSum[0], curSum);
            return root.val + Math.max(left, right);
        }
    }
}
