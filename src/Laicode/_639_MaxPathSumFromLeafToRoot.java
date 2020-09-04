package Laicode;

public class _639_MaxPathSumFromLeafToRoot {
    public class Solution1 {
        public int maxPathSumLeafToRoot(TreeNode root) {
            return helper(root, 0);
        }

        private int helper(TreeNode root, int sum) {
            sum += root.key;
            if(root.left == null && root.right == null) {
                return sum;
            }
            if(root.left == null) {
                return helper(root.right, sum);
            }
            if(root.right == null) {
                return helper(root.left, sum);
            }
            return Math.max(helper(root.left, sum), helper(root.right, sum));
        }
    }

    public class Solution2 {
        public int maxPathSumLeafToRoot(TreeNode root) {
            if(root.left == null && root.right == null) {
                return root.key;
            }
            if(root.left == null) {
                return maxPathSumLeafToRoot(root.right) + root.key;
            }
            if(root.right == null) {
                return maxPathSumLeafToRoot(root.left) + root.key;
            }
            return Math.max(maxPathSumLeafToRoot(root.left), maxPathSumLeafToRoot(root.right)) + root.key;
        }
    }

    public class Solution3 {
        public int maxPathSumLeafToRoot(TreeNode root) {
            int[] maxSum = new int[]{Integer.MIN_VALUE};
            helper(root, 0, maxSum);
            return maxSum[0];
        }

        private void helper(TreeNode root, int sum, int[] maxSum) {
            if(root == null) {
                return;
            }
            sum += root.key;
            if(root.left == null && root.right == null) {
                maxSum[0] = Math.max(maxSum[0], sum);
                return;
            }
            helper(root.left, sum, maxSum);
            helper(root.right, sum, maxSum);
        }
    }
}
