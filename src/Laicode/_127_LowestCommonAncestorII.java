package Laicode;

public class _127_LowestCommonAncestorII {

    public class TreeNodeP {
        public int key;
        public TreeNodeP left;
        public TreeNodeP right;
        public TreeNodeP parent;
        public TreeNodeP(int key, TreeNodeP parent) {
            this.key = key;
            this.parent = parent;
        }
    }

    public class Solution {
        public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
            int l1 = length(one);
            int l2 = length(two);

            if(l1 <= l2) {
                return mergeNode(one, two, l2 - l1);
            } else {
                return mergeNode(two, one, l1 - l2);
            }
        }

        private TreeNodeP mergeNode(TreeNodeP shorter, TreeNodeP longer, int diff) {
            while(diff-- > 0) {
                longer = longer.parent;
            }
            while(shorter != longer) {
                shorter = shorter.parent;
                longer = longer.parent;
            }
            return longer;
        }

        private int length(TreeNodeP node) {
            int length = 0;
            while(node != null) {
                node = node.parent;
                length++;
            }
            return length;
        }

    }
}
