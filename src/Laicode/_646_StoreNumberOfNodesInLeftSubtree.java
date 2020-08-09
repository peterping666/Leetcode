package Laicode;

public class _646_StoreNumberOfNodesInLeftSubtree {

    public class TreeNodeLeft {
        public int key;
        public TreeNodeLeft left;
        public TreeNodeLeft right;
        public int numNodesLeft;
        public TreeNodeLeft(int key) {
            this.key = key;
        }
    }

    public class Solution {
        public void numNodesLeft(TreeNodeLeft root) {
            helper(root);
        }

        private int helper(TreeNodeLeft root) {
            if(root == null) {
                return 0;
            }
            int left = helper(root.left);
            int right = helper(root.right);
            root.numNodesLeft = left;
            return left + right + 1;
        }
    }
}
