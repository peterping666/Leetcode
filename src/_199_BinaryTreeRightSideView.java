import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class _199_BinaryTreeRightSideView {
    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution1 {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if(root == null) {
                return res;
            }
            Queue<TreeNode> q = new ArrayDeque<>();
            q.offer(root);
            while(!q.isEmpty()) {
                int size = q.size();
                for(int i = 0; i < size; i++) {
                    TreeNode cur = q.poll();
                    if(i == 0) {
                        res.add(cur.val);
                    }
                    if(cur.right != null) {
                        q.offer(cur.right);
                    }
                    if(cur.left != null) {
                        q.offer(cur.left);
                    }
                }
            }
            return res;
        }
    }

    /**
     * Time O(n)
     * Space O(h)
     */
    class Solution2 {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if(root == null) {
                return res;
            }
            helper(root, res, 0);
            return res;
        }

        private void helper(TreeNode node, List<Integer> res, int level) {
            if(node == null) {
                return;
            }
            if(level == res.size()) {
                res.add(node.val);
            }
            helper(node.right, res, level + 1);
            helper(node.left, res, level + 1);
        }
    }
}
