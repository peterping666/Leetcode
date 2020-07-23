import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _1110_DeleteNodesAndReturnForest {

    class Solution {
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            List<TreeNode> res = new ArrayList<>();
            HashSet<Integer> seen = new HashSet<>();
            for(int num : to_delete) {
                seen.add(num);
            }
            if(!seen.contains(root.val)) {
                res.add(root);
            }
            helper(root, res, seen);
            return res;
        }

        private TreeNode helper(TreeNode root, List<TreeNode> res, HashSet<Integer> seen) {
            if(root == null) {
                return null;
            }
            root.left = helper(root.left, res, seen);
            root.right = helper(root.right, res, seen);
            if(seen.contains(root.val)) {
                if(root.left != null) {
                    res.add(root.left);
                }
                if(root.right != null) {
                    res.add(root.right);
                }
                return null;
            }
            return root;
        }
    }
}
