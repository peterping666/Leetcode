public class _979_DistributeCoinsinBinaryTree {
    class Solution {
        public int distributeCoins(TreeNode root) {
            int[] res = new int[1];
            helper(root, res);
            return res[0];
        }

        private int helper(TreeNode root, int[] res) {
            if(root == null) {
                return 0;
            }
            int left = helper(root.left, res);
            int right = helper(root.right, res);
            res[0] += Math.abs(left) + Math.abs(right);
            return root.val + left + right - 1;
        }
    }
}
