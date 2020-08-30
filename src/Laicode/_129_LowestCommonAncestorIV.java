package Laicode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _129_LowestCommonAncestorIV {
    public class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
            return helper(root, new HashSet<>(nodes));
        }

        private TreeNode helper(TreeNode root, Set<TreeNode> nodes) {
            if(root == null || nodes.contains(root)) {
                return root;
            }
            TreeNode left = helper(root.left, nodes);
            TreeNode right = helper(root.right, nodes);
            if(left != null && right != null) {
                return root;
            }
            return left != null ? left : right;
        }
    }
}
