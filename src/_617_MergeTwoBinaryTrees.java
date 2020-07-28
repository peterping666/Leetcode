public class _617_MergeTwoBinaryTrees {

    class Solution {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if(t1 == null && t2 == null) {
                return null;
            }
            TreeNode node = new TreeNode(0);
            TreeNode left1 = null, left2 = null, right1 = null, right2 = null;
            if(t1 != null) {
                node.val += t1.val;
                left1 = t1.left;
                right1 = t1.right;
            }
            if(t2 != null) {
                node.val += t2.val;
                left2 = t2.left;
                right2 = t2.right;
            }
            node.left = mergeTrees(left1, left2);
            node.right = mergeTrees(right1, right2);
            return node;
        }
    }

    /**
     *
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
