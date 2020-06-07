public class _530_MinimumAbsoluteDifferenceinBST {
    /**
     * Time O(n)
     * Space O(h)
     */
    int min = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int getMinimumDifference(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        return min;
    }

    private void helper(TreeNode node) {
        if(node == null) return;
        helper(node.left);
        if(pre != null) {
            min = Math.min(min, node.val - pre.val);
        }
        pre = node;
        helper(node.right);
    }
}
