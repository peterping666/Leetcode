import java.util.ArrayList;
import java.util.List;

public class _113_PathSum2 {
    /**
     * Time: O(n)
     * Space: O(h)
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        dfs(root, sum, new ArrayList<>(), res);
        return res;
    }

    private void dfs(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res) {
        if(root.left == null && root.right == null) {
            if(sum == root.val) {
                path.add(root.val);
                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        path.add(root.val);
        if(root.left != null) {
            dfs(root.left, sum - root.val, path, res);
        }
        if(root.right != null) {
            dfs(root.right, sum - root.val, path, res);
        }
        path.remove(path.size() - 1);
    }
}
