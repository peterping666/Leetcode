public class _1008_ConstructBinarySearchTreefromPreorderTraversal {
    class Solution1 {
        public TreeNode bstFromPreorder(int[] preorder) {
            return helper(preorder, new int[1], Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private TreeNode helper(int[] preorder, int[] pos, int min, int max) {
            if(pos[0] >= preorder.length || preorder[pos[0]] < min || preorder[pos[0]] > max) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[pos[0]++]);
            root.left = helper(preorder, pos, min, root.val);
            root.right = helper(preorder, pos, root.val, max);
            return root;
        }
    }

    class Solution2 {
        public TreeNode bstFromPreorder(int[] preorder) {
            return helper(preorder, new int[1], Integer.MAX_VALUE);
        }

        private TreeNode helper(int[] preorder, int[] pos, int max) {
            if(pos[0] >= preorder.length || preorder[pos[0]] > max) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[pos[0]++]);
            root.left = helper(preorder, pos, root.val);
            root.right = helper(preorder, pos, max);
            return root;
        }
    }
}
