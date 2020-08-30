package Laicode;

import java.util.ArrayDeque;
import java.util.Queue;

public class _504_ClosestNumberInBinarySearchTreeII {
    public class Solution {
        public int[] closestKValues(TreeNode root, double target, int k) {
            Queue<Integer> queue = new ArrayDeque<>();
            helper(root, queue, target, k);
            int[] res = new int[queue.size()];
            for(int i = 0; i < res.length; i++) {
                res[i] = queue.poll();
            }
            return res;
        }

        private void helper(TreeNode root, Queue<Integer> queue, double target, int k) {
            if(root == null) {
                return;
            }
            helper(root.left, queue, target, k);
            if(queue.size() < k) {
                queue.offer(root.key);
            } else if(Math.abs(queue.peek() - target) > Math.abs(root.key - target)) {
                queue.offer(root.key);
                queue.poll();
            } else {
                return;
            }
            helper(root.right, queue, target, k);
        }
    }
}
