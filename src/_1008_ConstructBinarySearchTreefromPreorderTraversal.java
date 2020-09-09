public class _1008_ConstructBinarySearchTreefromPreorderTraversal {
    class Solution {
        public TreeNode bstFromPreorder(int[] preorder) {
            return helper(preorder, 0, preorder.length - 1);
        }

        private TreeNode helper(int[] preorder, int left, int right) {
            if(left > right) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[left]);
            int index = findIndex(preorder, left + 1, right, root.val);
            root.left = helper(preorder, left + 1, index - 1);
            root.right = helper(preorder, index, right);
            return root;
        }

        private int findIndex(int[] preorder, int left, int right, int rootVal) {
            for(int i = left; i <= right; i++) {
                if(preorder[i] > rootVal) {
                    return i;
                }
            }
            return right + 1;
        }
    }
}
