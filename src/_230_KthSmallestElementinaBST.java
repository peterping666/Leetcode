import java.util.Stack;

public class _230_KthSmallestElementinaBST {
    /**
     * Time O(n)
     * Space O(h)
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest1(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            k--;
            if(k == 0) return cur.val;
            cur = cur.right;
        }
        return -1;
    }

    /**
     *
     */
    private int count;
    private int res;
    public int kthSmallest2(TreeNode root, int k) {
        count = k;
        helper(root);
        return res;
    }
    private void helper(TreeNode root) {
        if(root == null) return;
        helper(root.left);
        if(--count == 0) {
            res = root.val;
        }

        helper(root.right);
    }
}
