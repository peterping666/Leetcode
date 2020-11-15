import java.util.*;

public class _103_BinaryTreeZigzagLevelOrderTraversal {

    /**
     * root: level 0
     * even: poll first, append last
     * odd: poll last, append first
     */
    class Solution1 {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if(root == null) {
                return result;
            }
            Deque<TreeNode> deque = new ArrayDeque<>();
            boolean even = true;
            deque.offerFirst(root);
            while(!deque.isEmpty()) {
                int size = deque.size();
                List<Integer> list = new ArrayList<>();
                for(int i = 0; i < size; i++) {
                    TreeNode cur;
                    if(even) {
                        cur = deque.pollFirst();
                        if(cur.left != null) {
                            deque.offerLast(cur.left);
                        }
                        if(cur.right != null) {
                            deque.offerLast(cur.right);
                        }
                    } else {
                        cur = deque.pollLast();
                        if(cur.right != null) {
                            deque.offerFirst(cur.right);
                        }
                        if(cur.left != null) {
                            deque.offerFirst(cur.left);
                        }
                    }
                    list.add(cur.val);
                }
                even = !even;
                result.add(list);
            }
            return result;
        }
    }



    /**
     * Time O(n)
     * Space O(n)
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
                if(reverse) {
                    list.add(0, cur.val);
                } else {
                    list.add(cur.val);
                }
            }
            reverse = reverse ? false : true;
            res.add(list);
        }
        return res;
    }
}
