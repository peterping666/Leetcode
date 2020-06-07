import java.util.ArrayList;
import java.util.List;

public class _257_BTPath {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * Time: O(n)
     * Space: O(h)
     * @param root
     * @return
     */

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        dfs(root, res, "");
        return res;
    }

    private void dfs(TreeNode root, List<String> res, String path) {
        if(root.left == null && root.right == null) {
            res.add(path + root.val);
            return;
        }
        if(root.left != null) {
            dfs(root.left, res, path + root.val + "->");
        }
        if(root.right != null) {
            dfs(root.right, res, path + root.val + "->");
        }
    }

}
