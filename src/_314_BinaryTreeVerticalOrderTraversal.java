import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _314_BinaryTreeVerticalOrderTraversal {
    /**
     * Time O(n)
     * Space O(n)
     */
    int max;
    int min;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        max = 0;
        min = 0;
        helper(root, 0);
        for(int i = min; i <= max; i++) {
            res.add(new ArrayList<>());
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        queue.offer(root);
        index.offer(-min);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int idx = index.poll();
            res.get(idx).add(cur.val);
            if(cur.left != null) {
                queue.offer(cur.left);
                index.offer(idx - 1);
            }
            if(cur.right != null) {
                queue.offer(cur.right);
                index.offer(idx + 1);
            }
        }
        return res;
    }

    private void helper(TreeNode root, int index) {
        if(root == null) return;
        min = Math.min(min, index);
        max = Math.max(max, index);
        helper(root.left, index - 1);
        helper(root.right, index + 1);
    }
}
