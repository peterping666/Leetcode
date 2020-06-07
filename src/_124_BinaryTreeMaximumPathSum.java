public class _124_BinaryTreeMaximumPathSum {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if(root == null) return 0;
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);
        res = Math.max(res, root.val + left + right);
        return Math.max(left, right) + root.val;
    }
}
