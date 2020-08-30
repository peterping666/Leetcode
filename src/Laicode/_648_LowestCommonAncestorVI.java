package Laicode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _648_LowestCommonAncestorVI {
    public class Solution {
        public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, List<KnaryTreeNode> nodes) {
            return helper(root, new HashSet<>(nodes));
        }

        private KnaryTreeNode helper(KnaryTreeNode root, Set<KnaryTreeNode> nodes) {
            if(root == null || nodes.contains(root)) {
                return root;
            }
            KnaryTreeNode result = null;
            for(KnaryTreeNode node : root.children) {
                KnaryTreeNode cur = helper(node, nodes);
                if(cur != null) {
                    if(result != null) {
                        return root;
                    }
                    result = cur;
                }
            }
            return result;
        }
    }
}
