public class _236_LCAofBT {
    /**
     divide and conquer
     case1: cur node is null, return null
     case2: cur node is one of two nodes, return root
     case3: both children are not null(lca), return root
     case4: one of children is not null, return the not null child
     case5: both children are null, return null;
    */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // case1 & case2
            if(root == null || root == p || root == q) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            // case3
            if(left != null && right != null) {
                return root;
            }
            // case 4 & 5
            return left != null ? left : right;
        }
    }
}
