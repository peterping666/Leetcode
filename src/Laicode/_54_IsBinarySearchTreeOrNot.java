package Laicode;

public class _54_IsBinarySearchTreeOrNot {
    public class Solution {
        /**
         *
         * @param root
         * @return
         */
        public boolean isBST(TreeNode root) {
            return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        private boolean helper(TreeNode node, int lowerBound, int upperBound) {
            if(node == null) {
                return true;
            }
            if(node.key <= lowerBound || node.key >= upperBound) {
                return false;
            }
            return helper(node.left, lowerBound, node.key) && helper(node.right, node.key, upperBound);
        }
    }

}
