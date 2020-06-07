public class _111_MinimumDepthofBinaryTree {
    /**
     * Time O(n)
     * Space O(h)
     */
    int res = Integer.MAX_VALUE;
    public int minDepth1(TreeNode root) {
        if(root == null) {
            return 0;
        }
        helper(root, 1);
        return res;
    }

    private void helper(TreeNode root, int depth) {
        if(root.left == null && root.right == null) {
            res = Math.min(res, depth);
        }
        if(root.left != null) helper(root.left, depth + 1);
        if(root.right != null) helper(root.right, depth + 1);
    }

    /**
     * Time O(n)
     * Space O(h)
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null || root.right == null) {
            return Math.max(minDepth2(root.left), minDepth2(root.right)) + 1;
        }
        return Math.min(minDepth2(root.left), minDepth2(root.right)) + 1;
    }
}
