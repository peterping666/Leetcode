package Laicode;

public class _48_SymmetricBinaryTree {
    public class Solution {
        /**
         * Time O(n)
         * Space O(h)
         * @param root
         * @return
         */
        public boolean isSymmetric(TreeNode root) {
            if(root == null) {
                return true;
            }
            return helper(root.left, root.right);
        }

        private boolean helper(TreeNode left, TreeNode right) {
            if(left == null && right == null) {
                return true;
            }
            if(left == null || right == null || left.key != right.key) {
                return false;
            }
            return helper(left.left, right.right) && helper(left.right, right.left);
        }
    }
}
