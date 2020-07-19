package Laicode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _44_PreorderTraversalOfBinaryTree_iterative {
    public class Solution {
        public List<Integer> preOrder(TreeNode root) {
            List<Integer> preorder = new ArrayList<>();
            if(root == null) {
                return preorder;
            }
            Deque<TreeNode> stack = new ArrayDeque<>();
            stack.offerFirst(root);
            while(!stack.isEmpty()) {
                TreeNode cur = stack.pollFirst();
                preorder.add(cur.key);
                if(cur.right != null) {
                    stack.offerFirst(cur.right);
                }
                if(cur.left != null) {
                    stack.offerFirst(cur.left);
                }
            }
            return preorder;
        }
    }

}
