import java.util.LinkedList;
import java.util.Queue;

public class _117_PopulatingNextRightPointersinEachNodeII {
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
     * Space O(1)
     * @param root
     * @return
     */
    public Node connect2(Node root) {
        Node cur = root;
        Node head = null;
        Node pre = null;

        while(cur != null) {
            while(cur != null) {
                if(cur.left != null) {
                    if(pre != null) {
                        pre.next = cur.left;
                    } else head = cur.left;
                    pre = cur.left;
                }
                if(cur.right != null) {
                    if(pre != null) {
                        pre.next = cur.right;
                    } else head = cur.right;
                    pre = cur.right;
                }
                cur = cur.next;
            }
            cur = head;
            head = null;
            pre = null;
        }
        return root;
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
