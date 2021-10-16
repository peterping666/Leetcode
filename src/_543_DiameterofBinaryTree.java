public class _543_DiameterofBinaryTree {
    class Solution {
        public int diameterOfBinaryTree(TreeNode root) {
            int[] res = new int[1];
            helper(root, res);
            return res[0];
        }

        private int helper(TreeNode root, int[] res) {
            if(root == null) {
                return 0;
            }
            int left = helper(root.left, res);
            int right = helper(root.right, res);
            res[0] = Math.max(res[0], left + right);
            return Math.max(left, right) + 1;
        }
    }
}
