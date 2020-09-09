public class _114_FlattenBinaryTreetoLinkedList {
    class Solution {
        public void flatten(TreeNode root) {
            helper(root, new TreeNode[1]);
        }

        private void helper(TreeNode root, TreeNode[] prev) {
            if(root == null) {
                return;
            }
            helper(root.right, prev);
            helper(root.left, prev);
            root.right = prev[0];
            root.left = null;
            prev[0] = root;
        }
    }
}
