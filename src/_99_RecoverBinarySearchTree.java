public class _99_RecoverBinarySearchTree {
    /**
     * Time O(n)
     *  Space O(h)
     */
    class Solution {
        public void recoverTree(TreeNode root) {
            TreeNode[] first = new TreeNode[1];
            TreeNode[] second = new TreeNode[1];
            helper(root, first, second, new TreeNode[1]);
            int tmp = first[0].val;
            first[0].val = second[0].val;
            second[0].val = tmp;
        }

        private void helper(TreeNode root, TreeNode[] first, TreeNode[] second, TreeNode[] prev) {
            if(root == null) {
                return;
            }
            helper(root.left, first, second, prev);

            if(prev[0] != null && prev[0].val > root.val) {
                if(first[0] == null) {
                    first[0] = prev[0];
                }
                second[0] = root;
            }
            prev[0] = root;

            helper(root.right, first, second, prev);
        }
    }
}
