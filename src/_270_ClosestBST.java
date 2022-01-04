public class _270_ClosestBST {

    class Solution {
        public int closestValue(TreeNode root, double target) {
            int res = 0;
            double minDiff = Double.MAX_VALUE;
            while(root != null) {
                double diff = Math.abs(root.val - target);
                if(diff == 0) {
                    return root.val;
                }
                if(diff < minDiff) {
                    res = root.val;
                    minDiff = diff;
                }
                if(root.val > target) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
            return res;
        }
    }
}
