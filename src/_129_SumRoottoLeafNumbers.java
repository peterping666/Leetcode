public class _129_SumRoottoLeafNumbers {
    class Solution1 {
        public int sumNumbers(TreeNode root) {
            int[] res = new int[1];
            helper(root, 0, res);
            return res[0];
        }

        private void helper(TreeNode root, int pathSum, int[] res) {
            if(root.left == null && root.right == null) {
                res[0] += pathSum * 10 + root.val;
                return;
            }
            if(root.left != null) {
                helper(root.left, pathSum * 10 + root.val, res);
            }
            if(root.right != null) {
                helper(root.right, pathSum * 10 + root.val, res);
            }
        }
    }

    class Solution2 {
        public int sumNumbers(TreeNode root) {
            return helper(root, 0);
        }

        private int helper(TreeNode root, int pathSum) {
            if(root == null) return 0;
            if(root.left == null && root.right == null) {
                return pathSum * 10 + root.val;
            }
            return helper(root.left, pathSum * 10 + root.val)
                    + helper(root.right, pathSum * 10 + root.val);
        }
    }
}
