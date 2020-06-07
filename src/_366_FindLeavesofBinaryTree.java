import java.util.ArrayList;
import java.util.List;

public class _366_FindLeavesofBinaryTree {
    /**
     * Time O(n)
     * Space O(h)
     * @param root
     * @return
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        helper(root, res);
        return res;
    }

    private int helper(TreeNode root, List<List<Integer>> res) {
        if(root == null) return -1;
        int left = helper(root.left, res);
        int right = helper(root.right, res);
        int level = Math.max(left, right) + 1;
        if(res.size() <= level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        return level;
    }
}
