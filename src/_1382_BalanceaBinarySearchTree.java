import java.util.ArrayList;
import java.util.List;

public class _1382_BalanceaBinarySearchTree {
    class Solution {
        public TreeNode balanceBST(TreeNode root) {
            List<TreeNode> list = new ArrayList<>();
            inorder(root, list);
            return balance(list, 0, list.size() - 1);
        }

        private void inorder(TreeNode root, List<TreeNode> list) {
            if(root == null) {
                return;
            }
            inorder(root.left, list);
            list.add(root);
            inorder(root.right, list);
        }

        private TreeNode balance(List<TreeNode> list, int left, int right) {
            if(left > right) {
                return null;
            }
            int mid = left + (right - left) / 2;
            TreeNode node = list.get(mid);
            node.left = balance(list, left, mid - 1);
            node.right = balance(list, mid + 1, right);
            return node;
        }
    }
}
