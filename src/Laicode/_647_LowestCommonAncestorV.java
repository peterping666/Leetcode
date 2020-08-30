package Laicode;

public class _647_LowestCommonAncestorV {
    public class Solution {
        public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, KnaryTreeNode a, KnaryTreeNode b) {
            return helper(root, a, b);
        }

        private KnaryTreeNode helper(KnaryTreeNode root, KnaryTreeNode a, KnaryTreeNode b) {
            if(root == null || root == a || root == b) {
                return root;
            }
            KnaryTreeNode result = null;
            for(KnaryTreeNode node : root.children) {
                KnaryTreeNode cur = helper(node, a, b);
                if(cur != null) {
                    if(result == null) {
                        result = cur;
                    } else {
                        return root;
                    }
                }
            }
            return result;
        }
    }
}
