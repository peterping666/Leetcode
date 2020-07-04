public class _549_BinaryTreeLongestConsecutiveSequenceII {
    /**
     * Time O(n)
     * Space O(h)
     */
    int maxVal = 0;
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return maxVal;
    }

    private int[] helper(TreeNode node) {
        if(node == null) return new int[]{0,0};
        int inc = 1, dec = 1;
        if(node.left != null) {
            int[] left = helper(node.left);
            if(node.val == node.left.val + 1) {
                inc = left[0] + 1;
            } else if(node.val == node.left.val - 1) {
                dec = left[1] + 1;
            }
        }
        if(node.right != null) {
            int[] right = helper(node.right);
            if(node.val == node.right.val + 1) {
                inc = Math.max(inc, right[0] + 1);
            } else if(node.val == node.right.val - 1) {
                dec = Math.max(dec, right[1] + 1);
            }
        }
        maxVal = Math.max(maxVal, dec + inc - 1);
        return new int[]{inc, dec};
    }
}
