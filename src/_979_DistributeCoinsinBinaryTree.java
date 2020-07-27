public class _979_DistributeCoinsinBinaryTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        int ans;
        public int distributeCoins(TreeNode root) {
            ans = 0;
            dfs(root);
            return ans;
        }

        public int dfs(TreeNode node) {
            if (node == null) return 0;
            int L = dfs(node.left);
            int R = dfs(node.right);
            ans += Math.abs(L) + Math.abs(R);
            return node.val + L + R - 1;
        }
    }
}
