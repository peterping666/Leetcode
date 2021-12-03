import java.util.ArrayList;
import java.util.List;

public class _366_FindLeavesofBinaryTree {
    /**
     * Time O(n)
     * Space O(h)
     */
    class Solution {
        public List<List<Integer>> findLeaves(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            helper(root, res);
            return res;
        }

        private int helper(TreeNode root, List<List<Integer>> res) {
            if(root == null) {
                return -1;
            }
            int left = helper(root.left, res);
            int right = helper(root.right, res);
            int height = Math.max(left, right) + 1;
            if(height >= res.size()) {
                res.add(new ArrayList<>());
            }
            res.get(height).add(root.val);
            return height;
        }
    }
}
