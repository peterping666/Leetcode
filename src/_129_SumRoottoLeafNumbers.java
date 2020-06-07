public class _129_SumRoottoLeafNumbers {
    /**
     * Time O(n)
     * Space O(h)
     */
    int res = 0;
    public int sumNumbers1(TreeNode root) {
        if(root == null) {
            return 0;
        }
        helper1(root, 0);
        return res;
    }

    private void helper1(TreeNode root, int pathSum) {
        if(root.left == null && root.right == null) {
            res += (pathSum * 10 + root.val);
            return;
        }
        if(root.left != null) {
            helper1(root.left, pathSum * 10 + root.val);
        }
        if(root.right != null) {
            helper1(root.right, pathSum * 10 + root.val);
        }
    }

    /**
     * Time O(n)
     * Space O(h)
     * @param root
     * @return
     */
    public int sumNumbers2(TreeNode root) {
        return helper2(root, 0);
    }

    private int helper2(TreeNode root, int pathSum) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            return pathSum * 10 + root.val;
        }
        return helper2(root.left, pathSum * 10 + root.val)
                + helper2(root.right, pathSum * 10 + root.val);
    }
}
