package Laicode;

public class _128_LowestCommonAncestorIII {
    /**
     * public class TreeNode {
     *   public int key;
     *   public TreeNode left;
     *   public TreeNode right;
     *   public TreeNode(int key) {
     *     this.key = key;
     *   }
     * }
     */
    public class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root,
                                             TreeNode one, TreeNode two) {
            TreeNode res = helper(root, one, two);
            if(res == one) {
                if(helper(root, two, two) == null) {
                    return null;
                }
            }
            if(res == two) {
                if(helper(root, one, one) == null) {
                    return null;
                }
            }
            return res;
        }

        private TreeNode helper(TreeNode root, TreeNode one, TreeNode two) {
            if(root == null || root == one || root == two) {
                return root;
            }
            TreeNode left = helper(root.left, one, two);
            TreeNode right = helper(root.right, one, two);

            if(left != null && right != null) {
                return root;
            }
            return left != null ? left : right;
        }
    }
}
