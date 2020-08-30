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
            int height1 = getHeight(one);
            int height2 = getHeight(two);
            if(height1 > height2) {
                return mergeNode(two, one, height1 - height2);
            }
            return mergeNode(one, two, height2 - height1);
        }

        private TreeNodeP mergeNode(TreeNodeP shorter, TreeNodeP longer, int diff) {
            while(diff > 0) {
                longer = longer.parent;
                diff--;
            }
            while(longer != shorter) {
                longer = longer.parent;
                shorter = shorter.parent;
            }
            return longer;
        }

        private int getHeight(TreeNodeP node) {
            int height = 0;
            while(node != null) {
                node = node.parent;
                height++;
            }
            return height;
        }
    }
}
