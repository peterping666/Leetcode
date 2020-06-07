public class _270_ClosestBST {

    public int closestValue(TreeNode root, double target) {
        double minVal = Double.MAX_VALUE;
        int minNodeVal = root.val;
        while(root != null) {
            if(root.val == target) return root.val;
            if(Math.abs(root.val - target) < minVal) {
                minVal = Math.abs(root.val - target);
                minNodeVal = root.val;
            }
            if(root.val < target) {
                root = root.right;
            }else {
                root = root.left;
            }
        }
        return minNodeVal;
    }
}
