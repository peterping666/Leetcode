import java.util.LinkedList;
import java.util.Queue;

public class _513_FindBottomLeftTreeValue {
    /**
     * Time O(n)
     * Space O(n)
     * @param root
     * @return
     */
    public int findBottomLeftValue1(TreeNode root) {
        int ans = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur.right != null) {
                queue.offer(cur.right);
            }
            if(cur.left != null) {
                queue.offer(cur.left);
            }
            ans = cur.val;
        }
        return ans;
    }

    /**
     * Time O(n)
     * Space O(h)
     */
    int res = 0;
    int maxDepth = 0;
    public int findBottomLeftValue2(TreeNode root) {
        helper(root, 1);
        return res;
    }

    private void helper(TreeNode root, int depth) {
        if(root == null) return;
        if(depth > maxDepth) {
            res = root.val;
            maxDepth = depth;
        }
        helper(root.left, depth + 1);
        helper(root.right, depth + 1);
    }
}
