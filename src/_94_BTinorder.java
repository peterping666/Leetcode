import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94_BTinorder {
    class Solution1 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if(root == null) {
                return res;
            }
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while(cur != null || !stack.isEmpty()) {
                while(cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
            return res;
        }
    }

    class Solution2 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if(root == null) {
                return res;
            }
            helper(root, res);
            return res;
        }

        private void helper(TreeNode root, List<Integer> res) {
            if(root == null) {
                return;
            }
            helper(root.left, res);
            res.add(root.val);
            helper(root.right, res);
        }
    }
}
