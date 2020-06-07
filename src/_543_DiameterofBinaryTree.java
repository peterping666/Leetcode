public class _543_DiameterofBinaryTree {
    /**
     * Time O(n)
     * Space O(h)
     */
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        return diameter - 1;
    }

    private int helper(TreeNode root) {
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        diameter = Math.max(diameter, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
