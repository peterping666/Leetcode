package Laicode;

public class _51_InsertInBinarySearchTree {
    public class Solution1 {
        public TreeNode insert(TreeNode root, int key) {
            TreeNode newNode = new TreeNode(key);
            if(root == null) {
                return newNode;
            }
            TreeNode cur = root;
            while(cur.key != key) {
                if(cur.key < key) {
                    if(cur.right == null) {
                        cur.right = newNode;
                    }
                    cur = cur.right;
                } else {
                    if(cur.left == null) {
                        cur.left = newNode;
                    }
                    cur = cur.left;
                }
            }
            return root;
        }
    }

    public class Solution2 {
        public TreeNode insert(TreeNode root, int key) {
            if(root == null) {
                return new TreeNode(key);
            }
            if(key < root.key) {
                root.left = insert(root.left, key);
            } else if(key > root.key) {
                root.right = insert(root.right, key);
            }
            return root;
        }
    }
}
