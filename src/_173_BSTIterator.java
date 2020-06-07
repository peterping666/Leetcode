import java.util.Stack;

public class _173_BSTIterator {

    Stack<TreeNode> stack;
    TreeNode cur;
    public _173_BSTIterator(TreeNode root) {
        cur = root;
        stack = new Stack<>();
    }

    /** @return the next smallest number */
    public int next() {
        while(cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int val = cur.val;
        cur = cur.right;
        return val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        while(cur != null || !stack.isEmpty()) {
            return true;
        }
        return false;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
