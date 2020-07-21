package Laicode;

public class _53_DeleteInBinarySearchTree {

    public class Solution1 {
        public TreeNode deleteTree(TreeNode root, int key) {
            if(root == null) {
                return null;
            }
            TreeNode cur = root;

            if(cur.key == key) {
                // case 1,2
                if(cur.left == null) {
                    return cur.right;
                    //case 3
                } else if(cur.right == null) {
                    return cur.left;
                } else {
                    // case 4.1
                    if(cur.right.left == null) {
                        cur.right.left = cur.left;
                        return cur.right;
                        // case 4.2
                    } else {
                        TreeNode successor = findSuccessor(cur.right);
                        successor.left = cur.left;
                        successor.right = cur.right;
                        return successor;
                    }
                }
            } else if(key < cur.key) {
                cur.left = deleteTree(root.left, key);
            } else {
                cur.right = deleteTree(root.right, key);
            }

            return root;
        }

        private TreeNode findSuccessor(TreeNode root) {
            while (root.left.left != null) {
                root = root.left;
            }
            TreeNode successor = root.left;
            root.left = successor.right;
            return successor;
        }
    }

    /**
     *
     */
    public class Solution2 {
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
