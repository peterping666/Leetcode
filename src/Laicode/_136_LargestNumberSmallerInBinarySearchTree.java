package Laicode;

public class _136_LargestNumberSmallerInBinarySearchTree {
    public class Solution {
        public int largestSmaller(TreeNode root, int target) {
            int res = Integer.MIN_VALUE;
            while(root != null) {
                if(root.key >= target) {
                    root = root.left;
                } else {
                    res = root.key;
                    root = root.right;
                }
            }
            return res;
        }
    }
}
