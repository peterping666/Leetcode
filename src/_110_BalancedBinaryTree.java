public class _110_BalancedBinaryTree {
    /**
     * Time O(n)
     * Space O(h)
     */
    boolean isBlanced = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        helper(root);
        return isBlanced;
    }

    private int helper(TreeNode root) {
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if(Math.abs(left - right) > 1) {
            isBlanced = false;
        }
        return Math.max(left, right) + 1;
    }
}
