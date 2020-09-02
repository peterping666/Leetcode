package Laicode;

public class _135_ClosestNumberInBinarySearchTree {
    public class Solution {
        public int closest(TreeNode root, int target) {
            int res = root.key;
            while(root != null) {
                if(root.key == target) {
                    return target;
                }
                if(Math.abs(root.key - target) < Math.abs(res - target)) {
                    res = root.key;
                }
                if(root.key > target) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
            return res;
        }
    }

}
