package Laicode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _45_PostorderTraversalOfBinaryTree_iterative {
    public class Solution {
        public List<Integer> postOrder(TreeNode root) {
            List<Integer> postorder = new LinkedList<>();
            if(root == null) {
                return postorder;
            }
            Deque<TreeNode> stack = new ArrayDeque<>();
            stack.offerFirst(root);
            while(!stack.isEmpty()) {
                TreeNode cur = stack.pollFirst();
                postorder.add(0, cur.key);
                if(cur.left != null) {
                    stack.offerFirst(cur.left);
                }
                if(cur.right != null) {
                    stack.offerFirst(cur.right);
                }
            }
            return postorder;
        }
    }
}
