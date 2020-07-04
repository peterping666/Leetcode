public class _106_ConstructBinaryTreefromInorderandPostorderTraversal {
    /**
     * Time O(n)
     * Space O(h)
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, inorder.length - 1, 0, inorder.length-1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int postEnd, int left, int right) {
        if(postEnd < 0 || left > right) return null;
        int val = postorder[postEnd];
        int index = left;
        while(inorder[index] != val) {
            index++;
        }
        TreeNode root = new TreeNode(val);
        root.right = helper(inorder, postorder, postEnd - 1, index + 1, right);
        root.left = helper(inorder, postorder, postEnd - right + index - 1, left, index-1);
        return root;
    }
}
