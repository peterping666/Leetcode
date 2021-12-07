public class _105_ConstructBinaryTreefromPreorderandInorderTraversal {
    /**
     * Time O(n)
     * Space O(h)
     */
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return helper(preorder, inorder, 0, 0, preorder.length - 1);
        }

        private TreeNode helper(int[] preorder, int[] inorder, int preStart, int inLeft, int inRight) {
            if(preStart >= preorder.length || inLeft > inRight) return null;
            int val = preorder[preStart];
            TreeNode root = new TreeNode(val);
            int index = inLeft;
            while(inorder[index] != val) {
                index++;
            }
            root.left = helper(preorder, inorder, preStart+1, inLeft, index-1);
            root.right = helper(preorder, inorder, preStart + index - inLeft + 1, index+1, inRight);
            return root;
        }
    }
}
