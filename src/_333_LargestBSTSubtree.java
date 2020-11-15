public class _333_LargestBSTSubtree {
    /**
     * Time O(n)
     * Space O(h)
     */
    class Solution {
        public int largestBSTSubtree(TreeNode root) {
            int[] max = new int[1];
            helper(root, max);
            return max[0];
        }
        private SubTree helper(TreeNode root, int[] max) {
            if(root == null) {
                return new SubTree(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
            }
            SubTree left = helper(root.left, max);
            SubTree right = helper(root.right, max);
            if(left.size == -1 || right.size == -1 || root.val <= left.upper || root.val >= right.lower) {
                return new SubTree(-1, 0, 0);
            }
            int count = 1 + left.size + right.size;
            max[0] = Math.max(max[0], count);
            return new SubTree(count, Math.min(left.lower, root.val), Math.max(right.upper, root.val));
        }
        class SubTree {
            int size;
            int lower;
            int upper;

            SubTree(int size, int lower, int upper) {
                this.size = size;
                this.lower = lower;
                this.upper = upper;
            }
        }
    }
}
