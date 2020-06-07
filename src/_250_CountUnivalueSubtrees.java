public class _250_CountUnivalueSubtrees {
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) return 0;
        helper(root, root.val);
        return count;
    }

    private boolean helper(TreeNode root, int parentVal) {
        if(root == null) return true;
        boolean left = helper(root.left, root.val);
        boolean right = helper(root.right, root.val);
        if(left && right) {
            count++;
            return root.val == parentVal;
        }
        return false;
    }
}

