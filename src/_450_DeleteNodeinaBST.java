public class _450_DeleteNodeinaBST {
    /**
     * Time O(h)
     * Space O(h)
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if(root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if(root.left == null && root.right == null) {
                return null;
            } else if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }
            TreeNode successor = helper(root.right);
            root.val = successor.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private TreeNode helper(TreeNode node) {
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }
}
