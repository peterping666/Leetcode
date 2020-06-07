public class _99_RecoverBinarySearchTree {
    /**
     * Time O(n)
     *  Space O(h)
     */
    TreeNode first = null;
    TreeNode second = null;
    TreeNode pre = null;
    public void recoverTree(TreeNode root) {
        helper(root);
        if(first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
        return;
    }

    private void helper(TreeNode node) {
        if(node == null) return;
        helper(node.left);
        if(pre != null && pre.val > node.val) {
            if(first == null) first = pre;
            second = node;
        }
        pre = node;
        helper(node.right);
    }
}
