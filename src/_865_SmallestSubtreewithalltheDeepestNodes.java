import javafx.util.Pair;

public class _865_SmallestSubtreewithalltheDeepestNodes {
    class Solution {
        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            return helper(root).getValue();
        }

        private Pair<Integer, TreeNode> helper(TreeNode root) {
            if(root == null) {
                return new Pair(0, null);
            }
            Pair<Integer, TreeNode> left = helper(root.left);
            Pair<Integer, TreeNode> right = helper(root.right);
            int lDepth = left.getKey();
            int rDepth = right.getKey();
            if(lDepth == rDepth) {
                return new Pair(lDepth + 1, root);
            }
            return lDepth > rDepth ? new Pair(lDepth + 1, left.getValue()) : new Pair(rDepth + 1, right.getValue());
        }
    }
}
