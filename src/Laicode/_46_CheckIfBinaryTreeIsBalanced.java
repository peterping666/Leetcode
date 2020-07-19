package Laicode;

public class _46_CheckIfBinaryTreeIsBalanced {

    public class Solution {
        /**
         *
         * @param root
         * @return
         */
        public boolean isBalanced(TreeNode root) {
            return helper(root) != -1;
        }
        private int helper(TreeNode node) {
            if(node == null) {
                return 0;
            }
            int left = helper(node.left);
            if(left == -1) {
                return -1;
            }
            int right = helper(node.right);
            if(right == -1) {
                return -1;
            }
            if(Math.abs(left - right) > 1) {
                return -1;
            }
            return Math.max(left, right) + 1;
        }
    }

}
