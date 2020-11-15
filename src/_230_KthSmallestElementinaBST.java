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

    class Solution {
        public int kthSmallest(TreeNode root, int k) {
            int[] result = new int[2];
            result[0] = k;
            helper(root, result);
            return result[1];
        }

        private void helper(TreeNode root, int[] result) {
            if(root == null) {
                return;
            }
            helper(root.left, result);
            if(--result[0] == 0) {
                result[1] = root.val;
                return;
            }
            helper(root.right, result);
        }
    }
}
