public class _114_FlattenBinaryTreetoLinkedList {
    class Solution1 {
        public void flatten(TreeNode root) {
            if(root == null) {
                return;
            }
            helper(root, new TreeNode[1]);
        }

        private void helper(TreeNode root, TreeNode[] prev) {
            if(root == null) {
                return;
            }
            TreeNode left = root.left;
            TreeNode right = root.right;
            if(prev[0] != null) {
                prev[0].right = root;
            }
            root.left = null;
            prev[0] = root;
            helper(left, prev);
            helper(right, prev);
        }
    }

    class Solution2 {
        public void flatten(TreeNode root) {
            helper(root, new TreeNode[1]);
        }

        private void helper(TreeNode root, TreeNode[] next) {
            if(root == null) {
                return;
            }
            helper(root.right, next);
            helper(root.left, next);
            root.right = next[0];
            root.left = null;
            next[0] = root;
        }
    }


}
