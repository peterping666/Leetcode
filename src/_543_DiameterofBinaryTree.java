public class _543_DiameterofBinaryTree {
    /**
     * Time O(n)
     * Space O(h)
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int[] diameter = new int[1];
        helper(root, diameter);
        return diameter[0] - 1;
    }

    private int helper(TreeNode root, int[] diameter) {
        if(root == null) return 0;
        int left = helper(root.left, diameter);
        int right = helper(root.right, diameter);
        diameter[0] = Math.max(diameter[0], left + right + 1);
        return Math.max(left, right) + 1;
    }
}
