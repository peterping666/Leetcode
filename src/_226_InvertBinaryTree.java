public class _226_InvertBinaryTree {
    /**
     * Time O(n)
     * Space O(h)
     */
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if(root == null) {
                return root;
            }
            TreeNode left = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(left);
            return root;
        }
    }
}
