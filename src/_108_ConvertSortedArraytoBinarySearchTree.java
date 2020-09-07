public class _108_ConvertSortedArraytoBinarySearchTree {
    /**
     * Time O(n)
     * Space O(h)
     */
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return helper(nums, 0, nums.length - 1);
        }
        private TreeNode helper(int[] nums, int left, int right) {
            if(left > right) {
                return null;
            }
            int mid = left + (right - left) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = helper(nums, left, mid - 1);
            root.right = helper(nums, mid + 1, right);
            return root;
        }
    }
}
