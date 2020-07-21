package Laicode;

import java.util.*;

public class _45_PostorderTraversalOfBinaryTree_iterative {
    /**
     * Time O(n)
     * Space O(h)
     */
    public class Solution1 {
        public List<Integer> postOrder(TreeNode root) {
            List<Integer> postorder = new ArrayList<>();
            if(root == null) {
                return postorder;
            }
            Deque<TreeNode> stack = new ArrayDeque<>();
            stack.offerFirst(root);
            TreeNode prev = null;
            while(!stack.isEmpty()) {
                TreeNode cur = stack.peekFirst();
                // Going down
                if(prev == null || prev.left == cur || prev.right == cur) {
                    // going left
                    if(cur.left != null) {
                        stack.offerFirst(cur.left);
                        // going right
                    } else if(cur.right != null) {
                        stack.offerFirst(cur.right);
                        // down the end
                    } else {
                        stack.pollFirst();
                        postorder.add(cur.key);
                    }
                    // going up from right child
                } else if(prev == cur.right || prev == cur.left && cur.right == null) {
                    stack.pollFirst();
                    postorder.add(cur.key);
                    // going up from left child
                } else {
                    stack.offerFirst(cur.right);
                }
                prev = cur;
            }
            return postorder;
        }
    }

    /**
     * Time O(n)
     * Space O(n)
     */
    public class Solution2 {
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
