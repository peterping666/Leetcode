import java.util.ArrayList;
import java.util.List;

public class _95_UniqueBinarySearchTreesII {

    class Solution {
        public List<TreeNode> generateTrees(int n) {
            return helper(1, n);
        }

        private List<TreeNode> helper(int left, int right) {
            List<TreeNode> res = new ArrayList<>();
            if(left > right) {
                res.add(null);
                return res;
            }
            for(int i = left; i <= right; i++) {
                List<TreeNode> leftTrees = helper(left, i-1);
                List<TreeNode> rightTrees = helper(i+1, right);
                for(TreeNode leftTree : leftTrees) {
                    for(TreeNode rightTree : rightTrees) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftTree;
                        root.right = rightTree;
                        res.add(root);
                    }
                }
            }
            return res;
        }
    }
}
