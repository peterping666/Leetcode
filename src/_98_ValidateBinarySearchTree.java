public class _98_ValidateBinarySearchTree {
    /**
     * Time O(n)
     * Space O(h)
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        if(root == null) return true;
        if((max != null && root.val >= max) || (min != null && root.val <= min)) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    /**
     * Time O(n)
     * Space O(h)
     */
    class Solution2 {
        public boolean isValidBST(TreeNode root) {
            Integer[] pre = new Integer[1];
            return helper(root, pre);
        }

        private boolean helper(TreeNode root, Integer[] pre) {
            if(root == null) {
                return true;
            }
            if(!helper(root.left, pre)) {
                return false;
            }
            if(pre[0] != null && root.val <= pre[0]) {
                return false;
            }
            pre[0] = root.val;
            if(!helper(root.right, pre)) {
                return false;
            }
            return true;
        }
    }
}
