public class _98_ValidateBinarySearchTree {
    /**
     * Time O(n)
     * Space O(h)
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        if(root == null) return true;
        if((max != null && root.val >= max) || (min != null && root.val <= min)) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
