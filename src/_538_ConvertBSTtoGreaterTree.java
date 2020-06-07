public class _538_ConvertBSTtoGreaterTree {
    /**
     * Time O(n)
     * Space O(h)
     */
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }
    private void helper(TreeNode node) {
        if(node == null) return;
        helper(node.right);
        int temp = node.val;
        node.val += sum;
        sum += temp;
        helper(node.left);
    }
}
