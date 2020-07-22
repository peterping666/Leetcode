public class _938_RangeSumofBST {
    class Solution1 {
        public int rangeSumBST(TreeNode root, int L, int R) {
            if(root == null) {
                return 0;
            }
            int sum = 0;
            if(root.val > L) {
                sum += rangeSumBST(root.left, L, R);
            }
            if(root.val < R) {
                sum += rangeSumBST(root.right, L, R);
            }
            if(root.val >= L && root.val <= R) {
                sum += root.val;
            }
            return sum;
        }
    }

    class Solution2 {
        public int rangeSumBST(TreeNode root, int L, int R) {
            if(root == null) {
                return 0;
            }
            int left = root.val > L ? rangeSumBST(root.left, L, R) : 0;
            int right = root.val < R ? rangeSumBST(root.right, L, R) : 0;
            return left + right + (root.val >= L && root.val <= R ? root.val : 0);
        }
    }

    class Solution3 {
        public int rangeSumBST(TreeNode root, int L, int R) {
            if(root == null) {
                return 0;
            }
            if(root.val < L) return rangeSumBST(root.right, L, R);
            if(root.val > R) return rangeSumBST(root.left, L, R);
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        }
    }
}
