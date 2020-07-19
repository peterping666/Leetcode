package Laicode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _43_InorderTraversalOfBinaryTree_iterative {
    public class Solution {
        public List<Integer> inOrder(TreeNode root) {
            List<Integer> inorder = new ArrayList<>();
            if(root == null) {
                return inorder;
            }
            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode cur = root;
            while(!stack.isEmpty() || cur != null) {
                while(cur != null) {
                    stack.offerFirst(cur);
                    cur = cur.left;
                }
                cur = stack.pollFirst();
                inorder.add(cur.key);
                cur = cur.right;
            }
            return inorder;
        }
    }
}
