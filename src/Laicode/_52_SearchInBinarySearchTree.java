package Laicode;

public class _52_SearchInBinarySearchTree {
    public class Solution1 {
        public TreeNode search(TreeNode root, int key) {
            if(root == null || root.key == key) {
                return root;
            }
            return search(root.key < key ? root.right : root.left, key);
        }
    }

    public class Solution2 {
        public TreeNode search(TreeNode root, int key) {
            TreeNode cur = root;
            while(cur != null && cur.key != key) {
                cur = key < cur.key ? cur.left : cur.right;
            }
            return cur;
        }
    }
}
