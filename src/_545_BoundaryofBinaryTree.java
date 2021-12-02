import java.util.ArrayList;
import java.util.List;

public class _545_BoundaryofBinaryTree {
    /**
     * Time O(n)
     * Space O(h)
     */
    class Solution {
        public List<Integer> boundaryOfBinaryTree(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if(root == null) return list;
            list.add(root.val);
            leftBoundary(root.left, list);
            leaves(root.left, list);
            leaves(root.right, list);
            rightBoundary(root.right, list);
            return list;
        }

        private void leftBoundary(TreeNode node, List<Integer> list) {
            if(node == null || node.left == null && node.right == null) {
                return;
            }
            list.add(node.val);
            if(node.left == null) {
                leftBoundary(node.right, list);
            } else {
                leftBoundary(node.left, list);
            }
        }

        private void leaves(TreeNode node, List<Integer> list) {
            if(node == null) return;
            if(node.left == null && node.right == null) {
                list.add(node.val);
                return;
            }
            leaves(node.left, list);
            leaves(node.right, list);
        }

        private void rightBoundary(TreeNode node, List<Integer> list) {
            if(node == null || node.left == null && node.right == null) return;
            if(node.right == null) {
                rightBoundary(node.left, list);
            } else {
                rightBoundary(node.right, list);
            }
            list.add(node.val);
        }
    }
}
