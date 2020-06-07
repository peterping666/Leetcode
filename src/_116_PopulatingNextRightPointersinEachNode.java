import java.util.LinkedList;
import java.util.Queue;

public class _116_PopulatingNextRightPointersinEachNode {
    /**
     * Time O(n)
     * Space O(n)
     * @param root
     * @return
     */
    public Node connect1(Node root) {
        if(root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            Node pre = null;
            for(int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if(pre != null) {
                    pre.next = cur;
                }
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
                pre = cur;
            }
        }
        return root;
    }

    /**
     * Time O(n)
     * Space O(h)
     * @param root
     * @return
     */
    public Node connect2(Node root) {
        if(root == null) return null;
        if(root.left != null) {
            root.left.next = root.right;
        }
        if(root.next != null && root.right != null) {
            root.right.next = root.next.left;
        }
        connect2(root.left);
        connect2(root.right);
        return root;
    }

    /**
     * Time O(n)
     * Space O(1)
     * @param root
     * @return
     */
    public Node connect3(Node root) {
        if(root == null) return null;
        Node start = root;
        while(start != null) {
            Node cur = start;
            while(cur != null) {
                if(cur.left != null) {
                    cur.left.next = cur.right;
                }
                if(cur.next != null && cur.right != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            start = start.left;
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
