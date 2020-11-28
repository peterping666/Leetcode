import java.util.ArrayDeque;
import java.util.Queue;

public class _117_PopulatingNextRightPointersinEachNodeII {
    /**
     * Time O(n)
     * Space O(n)
     */
    class Solution {
        public Node connect(Node root) {
            if(root == null) {
                return root;
            }
            Queue<Node> queue = new ArrayDeque<>();
            queue.offer(root);
            while(!queue.isEmpty()) {
                int size = queue.size();
                Node prev = null;
                for(int i = 0; i < size; i++) {
                    Node cur = queue.poll();
                    if(prev != null) {
                        prev.next = cur;
                    }
                    if(cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if(cur.right != null) {
                        queue.offer(cur.right);
                    }
                    prev = cur;
                }
            }
            return root;
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node(int _val) {
            val = _val;
        }
    }
}
