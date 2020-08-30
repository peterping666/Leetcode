public class _368_LowestCommonAncestorBinarySearchTreeI {
    public class Solution {
        public TreeNode lca(TreeNode root, int p, int q) {
            int small = Math.min(p, q);
            int large = Math.max(p, q);
            while(root != null) {
                if(root.key >= small && root.key <= large) {
                    return root;
                }
                if(root.key < small) {
                    root = root.right;
                } else {
                    root = root.left;
                }
            }
            return null;
        }
    }

}
