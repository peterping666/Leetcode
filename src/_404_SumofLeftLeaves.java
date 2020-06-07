public class _404_SumofLeftLeaves {
    /**
     * Time O(n)
     * Space O(n)
     */
    int res = 0;
    public int sumOfLeftLeaves1(TreeNode root) {
        helper(root, null);
        return res;
    }

    private void helper(TreeNode root, TreeNode parent) {
        if(root == null) return;
        if(root.left == null && root.right == null && parent != null && parent.left == root) {
            res += root.val;
            return;
        }
        if(root.left != null) helper(root.left, root);
        if(root.right != null) helper(root.right, root);
    }

    /**
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves2(TreeNode root) {
        if(root == null) return 0;
        int res = 0;
        if(root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        }
        res += sumOfLeftLeaves2(root.left);
        res += sumOfLeftLeaves2(root.right);
        return res;
    }

}
