import java.util.*;

public class _272_ClosestBinarySearchTreeValueII {

    /**
     * Time O(n)
     * Space O(h)
     */
    class Solution1 {
        public List<Integer> closestKValues(TreeNode root, double target, int k) {
            List<Integer> res = new LinkedList<>();
            helper(root, res, target, k);
            return res;
        }

        private void helper(TreeNode root, List<Integer> res, double target, int k) {
            if(root == null) {
                return;
            }
            helper(root.left, res, target, k);
            if(res.size() == k) {
                if(target - res.get(0) <= root.val - target) {
                    return;
                } else {
                    res.remove(0);
                }
            }
            res.add(root.val);
            helper(root.right, res, target, k);
        }
    }

    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution2 {
        public List<Integer> closestKValues(TreeNode root, double target, int k) {
            Deque<Integer> stack = new ArrayDeque<>();
            Queue<Integer> queue = new ArrayDeque<>();
            inorder(root, target, stack, queue);
            List<Integer> res = new ArrayList<>();
            while(k-- > 0) {
                if(stack.isEmpty()) {
                    res.add(queue.poll());
                } else if(queue.isEmpty()) {
                    res.add(stack.pop());
                } else if(target - stack.peek() < queue.peek() - target){
                    res.add(stack.pop());
                } else {
                    res.add(queue.poll());
                }
            }
            return res;
        }

        private void inorder(TreeNode root, double target, Deque<Integer> stack, Queue<Integer> queue) {
            if(root == null) {
                return;
            }
            inorder(root.left, target, stack, queue);
            if(root.val <= target) {
                stack.push(root.val);
            } else {
                queue.offer(root.val);
            }
            inorder(root.right, target, stack, queue);
        }
    }
}
