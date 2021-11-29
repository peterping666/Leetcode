import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _1110_DeleteNodesAndReturnForest {

    class Solution {
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            List<TreeNode> res = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            for(int val : to_delete) {
                set.add(val);
            }
            helper(root, set, res, true);
            return res;
        }

        private TreeNode helper(TreeNode root, Set<Integer> set, List<TreeNode> res, boolean isRoot) {
            if(root == null) {
                return null;
            }
            if(isRoot && !set.contains(root.val)) {
                res.add(root);
            }
            boolean deleted = set.contains(root.val);
            root.left = helper(root.left, set, res, deleted);
            root.right = helper(root.right, set, res, deleted);
            return deleted ? null : root;
        }
    }
}
