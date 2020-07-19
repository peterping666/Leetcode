package Laicode;

public class _53_DeleteInBinarySearchTree {
    public class Solution {
        public TreeNode deleteTree(TreeNode root, int key) {
            if(root == null) {
                return null;
            }
            TreeNode cur = root;

            if(cur.key == key) {
                if(cur.left == null) {
                    return cur.right;
                } else if(cur.right == null) {
                    return cur.left;
                } else {
                    TreeNode successor = findSuccessor(cur.right);
                    cur.key = successor.key;
                    cur.right = deleteTree(cur.right, cur.key);
                }
            } else if(key < cur.key) {
                cur.left = deleteTree(root.left, key);
            } else {
                cur.right = deleteTree(root.right, key);
            }

            return root;
        }

        private TreeNode findSuccessor(TreeNode root) {
            while (root.left != null) {
                root = root.left;
            }
            return root;
        }
    }

}
