public class _1644_LowestCommonAncestorofaBinaryTreeII {
    class Solution1 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            int[] count = new int[1];
            TreeNode node = lca(root, p, q, count);
            return count[0] == 2 ? node : null;
        }

        public TreeNode lca(TreeNode root, TreeNode p, TreeNode q, int[] count) {
            if (root == null) {
                return null;
            }

            TreeNode left = lca(root.left, p, q, count);
            TreeNode right = lca(root.right, p, q, count);

            if (root == p || root == q) {
                count[0]++;
                return root;
            }

            if(left != null && right != null) {
                return root;
            }
            return left == null ? right : left;
        }
    }
}
