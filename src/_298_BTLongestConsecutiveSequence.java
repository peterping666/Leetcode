public class _298_BTLongestConsecutiveSequence {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * Time
     */
    private int res = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return res;
        dfs(root, root.val, 0);
        return res;
    }

    private void dfs(TreeNode root, int target, int max) {
        if(root == null) return;
        if(root.val == target) {
            max++;
        } else {
            max = 1;
        }
        res = Math.max(res, max);
        dfs(root.left, root.val + 1, max);
        dfs(root.right, root.val + 1, max);
    }
}
