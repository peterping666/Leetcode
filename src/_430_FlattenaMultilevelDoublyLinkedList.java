public class _430_FlattenaMultilevelDoublyLinkedList {
    /**
     * Time O(n)
     * Space O(1)
     */
    class Solution {
        public Node flatten(Node head) {
            Node cur = head;
            while(cur != null) {
                if(cur.child == null) {
                    cur = cur.next;
                    continue;
                }
                Node next = cur.next;
                Node child = flatten(cur.child);
                cur.next = child;
                child.prev = cur;
                cur.child = null;
                while(child.next != null) {
                    child = child.next;
                }
                if(next != null) {
                    child.next = next;
                    next.prev = child;
                }
                cur = next;
            }
            return head;
        }
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
}
