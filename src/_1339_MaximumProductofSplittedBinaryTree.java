public class _1339_MaximumProductofSplittedBinaryTree {

    class Solution1 {
        public int maxProduct(TreeNode root) {
            long sum = 0;
            long[] res = new long[1];
            sum = helper(root, res, sum);
            helper(root, res, sum);
            return (int)(res[0] % (int)(1e9+7));
        }

        private long helper(TreeNode root, long[] res, long sum) {
            if(root == null) {
                return 0;
            }
            long cur = root.val + helper(root.left, res, sum) + helper(root.right, res, sum);
            res[0] = Math.max(res[0], (sum - cur) * cur);
            return cur;
        }
    }

    class Solution2 {
        public int maxProduct(TreeNode root) {
            long sum = getSum(root);
            long[] res = new long[1];
            helper(root, res, sum);
            return (int)(res[0] % (int)(1e9+7));
        }

        private long getSum(TreeNode root) {
            if(root == null) {
                return 0;
            }
            return root.val + getSum(root.left) + getSum(root.right);
        }

        private long helper(TreeNode root, long[] res, long sum) {
            if(root == null) {
                return 0;
            }
            long cur = root.val + helper(root.left, res, sum) + helper(root.right, res, sum);
            res[0] = Math.max(res[0], (sum - cur) * cur);
            return cur;
        }
    }
}
