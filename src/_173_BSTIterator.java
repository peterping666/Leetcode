import java.util.ArrayDeque;
import java.util.Deque;

public class _173_BSTIterator {

    class BSTIterator {
        private Deque<TreeNode> stack;
        private TreeNode cur;

        public BSTIterator(TreeNode root) {
            stack = new ArrayDeque<>();
            cur = root;
        }

        /** @return the next smallest number */
        public int next() {
            while(cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            }
            cur = stack.pollFirst();
            int res = cur.val;
            cur = cur.right;
            return res;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            if(!stack.isEmpty() || cur != null) {
                return true;
            }
            return false;
        }
    }
}
