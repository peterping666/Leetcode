public class _1448_CountGoodNodesinBinaryTree {
    class Solution {
        public int goodNodes(TreeNode root) {
            int[] res = new int[1];
            helper(root, res, root.val);
            return res[0];
        }

        private void helper(TreeNode root, int[] res, int max) {
            if(root == null) {
                return;
            }
            if(root.val >= max) {
                res[0]++;
                max = root.val;
            }
            helper(root.left, res, max);
            helper(root.right, res, max);
        }
    }
}
