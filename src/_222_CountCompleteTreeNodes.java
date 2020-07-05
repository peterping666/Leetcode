public class _222_CountCompleteTreeNodes {
    /**
     * Time O(n)
     * Space O(n)`
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        return root != null ? 1 + countNodes(root.left) + countNodes(root.right) : 0;
    }
}
