public class _226_InvertBinaryTree {
    /**
     * Time O(n)
     * Space O(h)
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
