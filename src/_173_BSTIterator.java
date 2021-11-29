import java.util.ArrayDeque;
import java.util.Deque;

public class _173_BSTIterator {

    class BSTIterator {

        private Deque<TreeNode> stack;
        private TreeNode cur;

        public BSTIterator(TreeNode root) {
            cur = root;
            stack = new ArrayDeque<>();
        }

        public int next() {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            int res = cur.val;
            cur = cur.right;
            return res;
        }

        public boolean hasNext() {
            return !(stack.isEmpty() && cur == null);
        }
    }
}
